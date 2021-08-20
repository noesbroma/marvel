package com.example.marvel.ui.detail

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.marvel.data.list.Character

class DetailViewModel(): ViewModel() {
    lateinit var character: Character

    fun fetchIntentData(arguments: Bundle) {
        character = arguments?.getSerializable("EXTRA_CHARACTER") as Character
    }
}