package com.example.nhoelle.coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nhoelle.coroutines.model.SearchResult
import kotlinx.coroutines.experimental.launch

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val data = MutableLiveData<Resource<SearchResult>>()

    fun loadPicturesForQuery(query: String) {
        Log.d("MainViewModel", "query is $query")
        launch(uiContext) {
            try {
                data.value = Resource.onLoading() // show loading on UI thread
                val result = repo.loadData(query).await() // load away from UI thread
                data.value = Resource.onSuccess(result) // set color value on UI thread
            } catch (e: Exception) {
                data.value = Resource.onError(e.message ?: "some error happened")
                Log.d("MainViewModel", "exception is ${e.message}")
            }
        }
    }
}