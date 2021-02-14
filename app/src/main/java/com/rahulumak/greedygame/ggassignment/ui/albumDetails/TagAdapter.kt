package com.rahulumak.greedygame.ggassignment.ui.albumDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ItemTagBinding
import com.rahulumak.greedygame.ggassignment.model.GenreListModel

class TagAdapter : RecyclerView.Adapter<TagAdapter.TagItemHolder>() {
    var genreList = listOf<GenreListModel.Toptags.Tag>()
    var onGenreItemClickListener: OnTagItemClickListener? = null

    inner class TagItemHolder(private val binding: ItemTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GenreListModel.Toptags.Tag) {
            binding.apply {
                genre = item
            }

            binding.root.setOnClickListener {
                onGenreItemClickListener?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagItemHolder {
        return DataBindingUtil.inflate<ItemTagBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_tag,
            parent,
            false
        ).let {
            TagItemHolder(it)
        }
    }

    override fun onBindViewHolder(holder: TagItemHolder, position: Int) {
        holder.bind(genreList[position])
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnTagItemClickListener {
        fun onItemClicked(tag: GenreListModel.Toptags.Tag)
    }
}