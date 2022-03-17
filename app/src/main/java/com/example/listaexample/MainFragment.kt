package com.example.listaexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.listaexample.data.DataSource
import com.example.listaexample.databinding.FragmentMainBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.Adapter
import com.example.listaexample.utils.Utils
import com.google.gson.Gson


class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: Adapter
    private var news = DataSource.buildSimpleList().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycleView()
        initClicks()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().supportFragmentManager.setFragmentResultListener(
            Utils.REQUEST_KEY,
            viewLifecycleOwner
        ) { requestKey, result ->
            if (result.containsKey(Utils.NEW)) {
                val new = Gson().fromJson(
                    result.getString(Utils.NEW),
                    News::class.java
                )
                news.forEachIndexed { index, item ->
                    if (item.id == new.id) {
                        news[index] = new
                    }
                }
                adapter.notifyItemChanged(new.id)
            } else {
                val new = Gson().fromJson(
                    result.getString(Utils.SAVE),
                    News::class.java
                )
                news.add(new)
                adapter.notifyItemInserted(new.id)
            }
        }
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

        setupInformation()
        adapter.submitList(news)
    }

    private fun initClicks() {
        binding.floatingActionButton.setOnClickListener {
            (activity as MainActivity).navigateToSave()
        }
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
        const val TAG = "MainFragment"

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