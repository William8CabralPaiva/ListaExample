package com.example.listaexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listaexample.data.DataSource
import com.example.listaexample.databinding.ActivityMainBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.Adapter


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: Adapter
    private var news = DataSource.buildSimpleList().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.content_activity, MainFragment())
        transaction.commit()
    }

     fun navigateToEdit(new: News){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_activity, EditFragment.newInstance(new))
        transaction.commit()
    }

    fun navigateToMain(new: News){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_activity, MainFragment.newInstance(new))
        transaction.commit()
    }


}