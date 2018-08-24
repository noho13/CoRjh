package com.example.nhoelle.coroutines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.launch

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val color = MutableLiveData<Resource>()

    fun getColor() {
        launch(uiContext) {
            color.value = Resource.onLoading() // show loading on UI thread
            val colorValue = repo.loadColor().await() // load away from UI thread
            color.value = colorValue // set color value on UI thread
        }
    }

    fun loadUsers() {
        launch(uiContext) {
            try {
//                val users = repo.loadUsers().await()
//                Log.d("MainViewModel", "users size is ${users.size}")
            } catch (e: Exception) {
                Log.d("MainViewModel", "exception is ${e.message}")
            }
        }
    }
}