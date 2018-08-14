package com.example.nhoelle.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

//dispatches execution onto the Android main UI thread
val uiContext: CoroutineContext = UI

//represents a common pool of shared threads as the coroutine dispatcher
val bgContext: CoroutineContext = CommonPool