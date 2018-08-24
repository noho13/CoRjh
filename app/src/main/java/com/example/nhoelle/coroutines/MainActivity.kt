package com.example.nhoelle.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nhoelle.coroutines.ui.MainFragment

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val frag = MainFragment.createInstance()
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, frag)
                    .commit()
        }


//        setContentView(R.layout.activity_main)
//
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel.color.observe(this, androidx.lifecycle.Observer { t ->
//            when (t.state) {
//                State.LOADING -> progress.visibility = View.VISIBLE
//                else -> {
//                    progress.hide()
//                    text.setBackgroundColor(t.color)
//                }
//            }
//        })
//
//        button.setOnClickListener {
//        viewModel.getColor()
//            viewModel.loadUsers()
//        }
    }
}
