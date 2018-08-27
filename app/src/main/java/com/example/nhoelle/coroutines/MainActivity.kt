package com.example.nhoelle.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nhoelle.coroutines.ui.MainFragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val frag = MainFragment.createInstance()
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, frag)
                    .commit()
        }
    }
}
