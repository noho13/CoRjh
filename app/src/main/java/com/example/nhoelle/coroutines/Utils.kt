package com.example.nhoelle.coroutines

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment


fun Fragment.hideKeyboard(view: View) {
    val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun log(msg: String) = Log.d("Coroutine", "[${Thread.currentThread().name}] $msg")
