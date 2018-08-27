package com.example.nhoelle.coroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nhoelle.coroutines.model.Result
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val data = MutableLiveData<Resource<List<Result>>>()

    fun loadPicturesForQuery(query: String) {
        launch(uiContext) {
            try {
                log("loading")
                data.value = Resource.onLoading()
                val result = repo.loadData(query).await()
                val uiResult = withContext(bgContext) {
                    log("transforming data")
                    result.data
                            .map {
                                Result(it.description, it.assets.preview.url)
                            }
                }
                log("setting result")
                data.value = Resource.onSuccess(uiResult)
            } catch (e: Exception) {
                data.value = Resource.onError(e.message ?: "some error happened")
            }
        }
    }
}