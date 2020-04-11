package com.example.recyclerviewmvvmsimplifiedcoding

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.characters_fragment.*


class CharactersFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var viewModel: CharactersViewModel
    private lateinit var factory: CharactersViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.characters_fragment, container, false)
    }

    //we have a constructor parameter for our view model which we cannot pass like previous approach of viewmodels providers
    // so we will create a view model factory for that
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesAPI()
        val repository = MoviesRepository(api)
        factory = CharactersViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, factory).get(CharactersViewModel::class.java)
        viewModel.getMovies()
        viewModel.characters.observe(viewLifecycleOwner, Observer { characters ->
            recyclerView_characters.also {

                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = CharactersAdapter(characters, this)

            }


        })
    }

    override fun onRecyclerViewItemClick(view: View, charactersItem: CharactersItem) {
        when(view.id){
            R.id.button_book -> Toast.makeText(requireContext(), "${charactersItem.name} is booked", Toast.LENGTH_SHORT).show()
            R.id.layout_like -> Toast.makeText(requireContext(), "Layout Like is Clicked", Toast.LENGTH_SHORT).show()
        }

    }

}
