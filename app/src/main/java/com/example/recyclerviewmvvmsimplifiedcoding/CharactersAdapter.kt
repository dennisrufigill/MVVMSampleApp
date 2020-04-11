package com.example.recyclerviewmvvmsimplifiedcoding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvmsimplifiedcoding.databinding.RecyclerviewMovieBinding

class CharactersAdapter(private val characters: List<CharactersItem>, private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(
        val
        recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie, parent,false
            ))

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.characteritem = characters[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener{
         //   Toast.makeText(context, characters[position], Toast.LENGTH_SHORT ).show
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.buttonBook, characters[position])
        }
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener{
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.layoutLike, characters[position])
        }
    }


}
