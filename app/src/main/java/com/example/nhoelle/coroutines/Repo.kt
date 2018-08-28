package com.example.nhoelle.coroutines

import android.graphics.Bitmap
import android.graphics.Color
import com.example.nhoelle.coroutines.api.Service
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.*

class MainRepo {

    fun loadColor() = async(bgContext) {
        delay(5000L)
        Resource.onSuccess(createRandomColor())
    }

    private fun createRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    fun loadData(query: String) = Service.service.getSearchResult(query)

    fun saveBitmap(bitmap: Bitmap) {

    }

}