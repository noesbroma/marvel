package com.example.marvel.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.marvel.R
import com.example.marvel.data.list.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment: Fragment() {
    companion object {
        fun newInstance(character: Character): DetailFragment {
            val fragment = DetailFragment()

            val args = Bundle()
            args.putSerializable("EXTRA_CHARACTER", character)
            fragment.arguments = args

            return fragment
        }
    }

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { viewModel.fetchIntentData(it) }
        setUI()
    }


    private fun setUI() {
        name.text = viewModel.character.name
        description.text = viewModel.character.description
        comics.text = "Comics: " + viewModel.character.comics.available.toString()
        series.text = "Stories: " + viewModel.character.stories.available.toString()
        stories.text = "Series: " + viewModel.character.series.available.toString()
        events.text = "Eventos: " + viewModel.character.events.available.toString()

        if (viewModel.character.thumbnail.path != "") {
            val url = viewModel.character.thumbnail.path + "." + viewModel.character.thumbnail.extension
            val picasso = Picasso.get()

            picasso.load(url)
                .into(image)
        } else {
        }
    }
}