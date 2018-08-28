package com.example.nhoelle.coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nhoelle.coroutines.model.Result
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val data = MutableLiveData<Resource<List<Result>>>()

    fun loadPicturesForQuery(query: String) {
        launch(uiContext) {
            try {
                data.value = Resource.onLoading()

                val result = repo.loadData(query).await()
                val uiResult = withContext(bgContext) {
                    result.data
                            .map {
                                Result(it.description, it.assets.preview.url)
                            }
                }
                data.value = Resource.onSuccess(uiResult)
            } catch (e: Exception) {
                data.value = Resource.onError(e.message ?: "some error happened")
            }
        }
    }

    fun saveBitmap(item: Result) {
        launch(UI) {
            withContext(bgContext) {
                val bitmap = Picasso.get().load(item.url).get()
                Log.d("MainViewModel", "bitmap is ${bitmap.byteCount}")
                repo.saveBitmap(bitmap)
            }
        }
    }
}