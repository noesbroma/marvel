package com.example.marvel.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.R
import com.example.marvel.data.list.CharacterListItem
import com.example.marvel.data.list.CharactersRecyclerAdapter
import com.example.marvel.ui.MainActivity
import com.example.marvel.ui.detail.DetailFragment
import com.example.marvel.ui.list.ListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_item_row.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {
    companion object {
        fun newInstance(): ListFragment {
            val fragment = ListFragment()

            return fragment
        }
    }


    private val viewModel: ListViewModel by viewModel()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var charactersList: ArrayList<CharacterListItem> = ArrayList<CharacterListItem>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacters()

        observeViewModel()
    }


    private fun observeViewModel() {
        viewModel.onLoadCharactersEvent.observe(viewLifecycleOwner, androidx.lifecycle.Observer { characters ->
            linearLayoutManager = LinearLayoutManager(context)
            charactersRecycler.layoutManager = linearLayoutManager
            charactersRecycler.hasFixedSize()

            charactersList = characters

            val mAdapter = context?.let { CharactersRecyclerAdapter(charactersList) }

            mAdapter?.setOnItemClickListener(object : CharactersRecyclerAdapter.ClickListener {
                override fun onItemClick(v: View, position: Int) {
                    (activity as MainActivity).openFragment(DetailFragment.newInstance(characters[position]))
                }

            })

            if (charactersList.size > 0) {
                charactersRecycler.adapter?.notifyDataSetChanged()
                charactersRecycler.adapter = mAdapter
            } else {
                //noResults.visibility = View.VISIBLE
            }
        })
    }
}