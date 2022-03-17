package com.example.listaexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listaexample.databinding.FragmentEditBinding
import com.example.listaexample.model.News
import com.example.listaexample.utils.Utils
import com.google.gson.Gson


class EditFragment : Fragment() {

    private val binding by lazy { FragmentEditBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { (activity as MainActivity) }
    private var newSend: News? = null
    private var idNew = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInformation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {
            newSend?.let {
                val new =
                    News(
                        it.id,
                        binding.title.text.toString(),
                        binding.description.text.toString(),
                        binding.author.text.toString(),
                        it.imgUrl
                    )
                val bundle = Bundle()
                bundle.putString(Utils.NEW, Gson().toJson(new))
                requireActivity().supportFragmentManager.setFragmentResult(
                    Utils.REQUEST_KEY,
                    bundle
                )
                mainActivity.navigateToMain()
            }
        }
    }

    private fun setupInformation() {
        if (arguments != null) {
            if (requireArguments().containsKey(KEY_NEW)) {
                val new = Gson().fromJson(
                    arguments?.getString(KEY_NEW),
                    News::class.java
                )

                newSend = new
                binding.title.setText(new.title)
                binding.description.setText(new.description)
                binding.author.setText(new.author)
                idNew = new.id
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    companion object {
        const val KEY_NEW = "key_new"

        @JvmStatic
        fun newInstance(new: News? = null) = EditFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_NEW, Gson().toJson(new))
            }
        }

    }


}