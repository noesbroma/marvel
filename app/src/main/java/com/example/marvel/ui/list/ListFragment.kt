package com.example.marvel.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.marvel.R
import com.example.marvel.ui.list.ListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment: Fragment() {
    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()

            return fragment
        }
    }


    private val viewModel: ListViewModel by viewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacters()
        /*setUI()
        setListeners()
        observeViewModel()*/
    }

}