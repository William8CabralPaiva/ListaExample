package com.example.listaexample.utils

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.listaexample.databinding.DefaultItemBinding
import com.example.listaexample.databinding.SecondItemBinding
import com.example.listaexample.databinding.ThirdItemBinding
import com.example.listaexample.model.News

sealed class NewsViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class DefaultViewHolder(private val binding: DefaultItemBinding, private val context: Context) :
        NewsViewHolder(binding) {
        fun bind(
            news: News,
            onClick: (News) -> Unit
        ) {

            binding.apply {
                title.text = news.title
                author.text = news.author
                description.text = news.description
                Glide.with(context).load(news.imgUrl).into(image)
                container.setOnClickListener { onClick(news) }
            }
        }
    }

    class SecondViewHolder(private val binding: SecondItemBinding, private val context: Context) :
        NewsViewHolder(binding) {
        fun bind(
            news: News,
            onClick: (News) -> Unit
        ) {

            binding.apply {
                val _title = news.title.resume(50)
                val _description = news.description.resume(100)

                title.text = _title
                author.text = news.author
                description.text = _description
                Glide.with(context).load(news.imgUrl).into(image)
                container.setOnClickListener { onClick(news) }
            }
        }
    }

    class ThirdViewHolder(private val binding: ThirdItemBinding, private val context: Context) :
        NewsViewHolder(binding) {
        fun bind(
            news: News,
            onClick: (News) -> Unit
        ) {

            binding.apply {

                val _title = news.title.resume(50)

                title.text = _title
                author.text = news.author
                description.text = news.description
                Glide.with(context).load(news.imgUrl).into(image)
                container.setOnClickListener { onClick(news) }
            }
        }
    }

    fun String.resume(size: Int): String {
        if (this.length > size) {
            return this.substring(0, size) + "..."
        }
        return this
    }
}