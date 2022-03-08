package com.example.listaexample

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.listaexample.data.DataSource
import com.example.listaexample.databinding.ActivityMainBinding
import com.example.listaexample.databinding.FragmentMainBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.Adapter
import com.google.gson.Gson

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: Adapter
    private var news = DataSource.buildSimpleList().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycleView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun initRecycleView() {
        adapter = Adapter(requireContext()).apply {
            onClick = { news ->
                (activity as MainActivity).navigateToEdit(news)
            }
        }

        val gesture = ItemTouchHelper(
            touch()
        )

        binding.recycleView.adapter = adapter
        gesture.attachToRecyclerView(binding.recycleView)

        //binding.recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setupInformation()
        adapter.submitList(news.toList())
    }

    private fun setupInformation() {
        if (arguments != null) {
            if (requireArguments().containsKey(EditFragment.KEY_NEW)) {
                val new = Gson().fromJson(
                    arguments?.getString(EditFragment.KEY_NEW),
                    News::class.java
                )
                news.forEachIndexed { index, item ->
                    if (item.id == new.id) {
                        news[index] = new
                    }

                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun touch() = object : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.LEFT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition;
            news.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(new: News): MainFragment {
            val args = Bundle()
            args.putString(EditFragment.KEY_NEW, Gson().toJson(new))
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

}