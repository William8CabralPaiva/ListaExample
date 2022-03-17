package com.example.listaexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.listaexample.data.DataSource
import com.example.listaexample.databinding.ActivityMainBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.Adapter


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var adapter: Adapter
    private var news = DataSource.buildSimpleList().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.content_activity, MainFragment(), MainFragment.TAG)
            transaction.commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        val transaction = supportFragmentManager.beginTransaction()
//        supportFragmentManager.findFragmentByTag(MainFragment.TAG)?.let { transaction.remove(it) }
//        transaction.commit()
        binding = null
    }

    fun navigateToEdit(new: News) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .addToBackStack(null)
            .replace(R.id.content_activity, EditFragment.newInstance(new))
            .commit()
    }

    fun navigateToSave() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_activity, AddFragment.newInstance())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun navigateToMain() {
        val manager: FragmentManager = supportFragmentManager
        manager.popBackStack()
    }

}