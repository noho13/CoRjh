package com.example.nhoelle.coroutines.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nhoelle.coroutines.MainViewModel
import com.example.nhoelle.coroutines.R
import com.example.nhoelle.coroutines.State
import kotlinx.android.synthetic.main.fr_main.*


private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    companion object {
        fun createInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            (it as AppCompatActivity).setSupportActionBar(toolbar)
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.data.observe(this, Observer {
            it?.let {
                when (it.state) {
                    State.LOADING -> progress.visibility = View.VISIBLE
                    State.Success -> {
                        progress.visibility = View.GONE
                        Log.d(TAG, "success with result ${it.data}")
                    }
                    State.ERROR -> {
                        progress.visibility = View.GONE
                        Log.d(TAG, "error with message ${it.message}")
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchItem.collapseActionView()
                startSearchFor(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun startSearchFor(searchQuery: String) {
        Log.d(TAG, "search for $searchQuery")
        viewModel.loadPicturesForQuery(searchQuery)
    }
}