package com.example.marvel.data.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_item_row.view.*
import java.util.*


class CharactersRecyclerAdapter(
    var characters: ArrayList<Character>
): RecyclerView.Adapter<CharactersRecyclerAdapter.CharacterHolder>(){


    private var clickListener: ClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item_row, parent, false)

        return CharacterHolder(v)
    }


    override fun getItemCount(): Int {
        return characters.size
    }


    fun getItemName(position: Int): String? {
        return characters?.get(position).name
    }


    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }


    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val data = characters?.get(position)
        data?.let { holder.bindItems(it) }
    }


    inner class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            if (clickListener != null) {
                itemView.setOnClickListener(this)
            }
        }


        fun bindItems(character: Character) {
            itemView.name.text = character.name
            itemView.description.text = character.description

            val url = character.thumbnail.path + "." + character.thumbnail.extension

            if (url != "") {
                val picasso = Picasso.get()

                picasso.load(url)
                .into(itemView.image)
            } else {
            }
        }


        override fun onClick(v: View?) {
            if (v != null) {
                clickListener?.onItemClick(v,adapterPosition)
            }
        }
    }

    interface ClickListener {
        fun onItemClick(v: View,position: Int)
    }
}