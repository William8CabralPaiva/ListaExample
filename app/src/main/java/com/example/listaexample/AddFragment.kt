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
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class AddFragment : Fragment() {

    private val binding by lazy { FragmentEditBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { (activity as MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.save.setOnClickListener {

            val new =
                News(
                    randomId(),
                    binding.title.text.toString(),
                    binding.description.text.toString(),
                    binding.author.text.toString(),
                    randomImg(),
                )

            val bundle = Bundle()
            bundle.putString(Utils.SAVE, Gson().toJson(new))
            requireActivity().supportFragmentManager.setFragmentResult(Utils.REQUEST_KEY, bundle)
            mainActivity.navigateToMain()

        }
    }

    fun randomImg(): String {
        val random = ThreadLocalRandom.current().nextInt(1, 6)
        val imgs = listOf(
            "https://fdn.gsmarena.com/imgroot/news/19/12/phones-of-the-decade/-727w2/gsmarena_001.jpg",
            "https://cdn.pocket-lint.com/r/s/970x/assets/images/124434-phones-news-buyer-s-guide-best-android-phones-image30-r9f0oldzd7-jpg.webp?v1",
            "https://cdn.pocket-lint.com/r/s/660x/assets/images/120810-phones-news-buyer-s-guide-upcoming-smartphones-image76-pc92hfjamx-jpg.webp?v1",
            "https://i.pcmag.com/imagery/reviews/01pr6hmgqz7A5wX5hSQWqRs-1.fit_lim.size_625x365.v1632764534.jpg",
            "https://cdn.thewirecutter.com/wp-content/media/2021/08/budget-android-phone-2048px-2x1-1.jpg?auto=webp&quality=75&crop=2:1&width=980&dpr=2",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUafJfUzKrIvmG4P0728CCnB9SEVCKjsk_PFdxIo2ZyNkWhsgYW4e9RI5zZDRSq7p5sYk&usqp=CAU"
        )
        return imgs[random]
    }

    fun randomId(): Int {
        val random = ThreadLocalRandom.current().nextInt(10, 99)
        return random
    }

    companion object {

        @JvmStatic
        fun newInstance(): AddFragment {
            return AddFragment()
        }
    }

}