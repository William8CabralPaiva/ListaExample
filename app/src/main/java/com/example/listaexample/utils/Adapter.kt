package com.example.listaexample.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.listaexample.databinding.DefaultItemBinding
import com.example.listaexample.databinding.SecondItemBinding
import com.example.listaexample.databinding.ThirdItemBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.NewsViewHolder.Companion.typeViewHolder

class Adapter(private val context: Context) : ListAdapter<News, NewsViewHolder>(DIFF_CALLBACK) {

    lateinit var onClick: (News) -> Unit
    var position = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return typeViewHolder(parent, context, viewType)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        when (holder) {
            is NewsViewHolder.DefaultViewHolder -> holder.bind(news, onClick)
            is NewsViewHolder.SecondViewHolder -> holder.bind(news, onClick)
            is NewsViewHolder.ThirdViewHolder -> holder.bind(news, onClick)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).id
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(
                oldItem: News,
                newItem: News
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: News,
                newItem: News
            ): Boolean = oldItem == newItem
        }
    }
}