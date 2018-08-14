package com.example.nhoelle.coroutines

import android.graphics.Color

class Resource(var state: State, var color: Int) {
    companion object {
        fun onLoading() = Resource(State.LOADING, Color.TRANSPARENT)
        fun onReady(color: Int) = Resource(State.READY, color)
    }
}