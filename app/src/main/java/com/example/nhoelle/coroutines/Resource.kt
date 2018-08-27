package com.example.nhoelle.coroutines

class Resource<T>(var state: State, var data: T?, var message: String? = null) {
    companion object {
        fun <T> onLoading() = Resource<T>(State.LOADING, null)
        fun <T> onSuccess(data: T) = Resource(State.Success, data)
        fun <T> onError(message: String) = Resource<T>(State.ERROR, null, message)
    }
}