package com.rahulumak.greedygame.ggassignment.ui.genreList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.FragmentGenreListBinding
import com.rahulumak.greedygame.ggassignment.databinding.GenreDetailsFragmentBinding
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragment
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.GenreDetailsFragmentDirections
import kotlinx.android.synthetic.main.fragment_genre_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class GenreListFragment : Fragment(), GenreListAdapter.OnGenreItemClickListener {
    private val genreListViewModel: GenreListViewModel by viewModel()
    private val genreListAdapter = GenreListAdapter()
    private var binding: FragmentGenreListBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding != null) {
            return binding!!.root
        }
        binding = FragmentGenreListBinding.inflate(inflater, container, false)
        context ?: return binding!!.root
        binding?.apply {
            lifecycleOwner = this@GenreListFragment
            viewModel = genreListViewModel
            genreAdapter = genreListAdapter
        }
        val view = binding!!.root

        view.btExpand.setOnClickListener {
            genreListViewModel.fetchGenreList(false)
        }

        genreListViewModel.fetchGenreList(true)

        genreListAdapter.onGenreItemClickListener = this

        return view
    }

    override fun onItemClicked(tag: GenreListModel.Toptags.Tag) {
        val direction = GenreListFragmentDirections.actionNavigationGenreListToNavigationGenreDetails(tag.name)
        findNavController().navigate(direction)
    }
}