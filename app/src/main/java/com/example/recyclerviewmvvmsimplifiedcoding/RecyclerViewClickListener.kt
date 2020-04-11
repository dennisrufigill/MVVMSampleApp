package com.example.recyclerviewmvvmsimplifiedcoding

import android.view.View

interface RecyclerViewClickListener {

    fun onRecyclerViewItemClick(view : View, charactersItem: CharactersItem)
}