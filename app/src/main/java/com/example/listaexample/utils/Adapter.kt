package com.example.listaexample.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.listaexample.databinding.DefaultItemBinding
import com.example.listaexample.databinding.SecondItemBinding
import com.example.listaexample.databinding.ThirdItemBinding
import com.example.listaexample.model.News

class Adapter(private val context: Context) : ListAdapter<News, NewsViewHolder>(DIFF_CALLBACK) {

    lateinit var onClick: (News) -> Unit

    var globalPosition = 0;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        globalPosition++;
        return when {
            globalPosition % 3 == 0 -> {
                val binding =
                    ThirdItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NewsViewHolder.ThirdViewHolder(binding, context)
            }
            globalPosition % 2 == 0 -> {
                val binding =
                    SecondItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NewsViewHolder.SecondViewHolder(binding, context)
            }
            else -> {
                val binding =
                    DefaultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NewsViewHolder.DefaultViewHolder(binding, context)
            }
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        when (holder) {
            is NewsViewHolder.DefaultViewHolder -> holder.bind(news, onClick)
            is NewsViewHolder.SecondViewHolder -> holder.bind(news, onClick)
            is NewsViewHolder.ThirdViewHolder -> holder.bind(news, onClick)
        }
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