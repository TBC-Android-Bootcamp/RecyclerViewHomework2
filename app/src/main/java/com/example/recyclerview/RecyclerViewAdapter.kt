package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycleview_layout.view.*

class RecyclerViewAdapter (private val items: MutableList<ItemModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object:RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate( //
                R.layout.item_recycleview_layout,
                parent,
                false
            )
        ){}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val model = items[position]
        holder.itemView.imageView.setImageResource(model.image)
        holder.itemView.titleTextView.text = model.title
        holder.itemView.descriptionTextView.text = model.description
        holder.itemView.authorTextView.text = model.author
        holder.itemView.setOnLongClickListener{
            removeItemAt(position)
            true
        }
    }

    fun addItem(item:ItemModel){
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun removeItemAt(position: Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

}