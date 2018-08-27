package com.example.nhoelle.coroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nhoelle.coroutines.R
import com.example.nhoelle.coroutines.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class RVAdapter(var data: List<Result> = emptyList()) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(item: Result): Unit = with(itemView) {
            Picasso.get().load(item.url).into(iv_picture)
            tv_line1.text = item.description
        }
    }
}