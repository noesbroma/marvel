package com.example.marvel.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.marvel.R
import com.example.marvel.data.list.CharacterListItem
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment() {
    companion object {
        fun newInstance(characterListItem: CharacterListItem): DetailFragment {
            val fragment = DetailFragment()

            val args = Bundle()
            args.putString("EXTRA_CHARACTER", characterListItem.name)
            fragment.arguments = args

            return fragment
        }

        var cname = ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cname = arguments?.getString("EXTRA_CHARACTER").toString()
        setUI()
    }


    private fun setUI() {
        name.text = cname
    }
}