package com.rahulumak.greedygame.ggassignment.ui.genreList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ItemGenreBinding
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreListAdapter : RecyclerView.Adapter<GenreListAdapter.GenreItemHolder>() {
    var itemList = listOf<GenreListModel.Toptags.Tag>()
    var onGenreItemClickListener: OnGenreItemClickListener? = null

    inner class GenreItemHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GenreListModel.Toptags.Tag) {
            binding.apply {
                genreItem = item
            }

            binding.root.tvGenreName.setOnClickListener {
                onGenreItemClickListener?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreItemHolder {
        return DataBindingUtil.inflate<ItemGenreBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_genre,
            parent,
            false
        ).let {
            GenreItemHolder(it)
        }
    }

    override fun onBindViewHolder(holder: GenreItemHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnGenreItemClickListener {
        fun onItemClicked(tag: GenreListModel.Toptags.Tag)
    }
}