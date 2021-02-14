package com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ItemAlbumBinding
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import kotlinx.android.synthetic.main.item_genre.view.*

class AlbumListAdapter : RecyclerView.Adapter<AlbumListAdapter.AlbumItemHolder>() {
    var albumList = listOf<TopAlbumListModel.Albums.Album>()
    var onAlbumItemClickListener: OnAlbumItemClickListener? = null

    inner class AlbumItemHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TopAlbumListModel.Albums.Album) {
            binding.apply {
                album = item
            }

            binding.root.setOnClickListener {
                onAlbumItemClickListener?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumItemHolder {
        return DataBindingUtil.inflate<ItemAlbumBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_album,
            parent,
            false
        ).let {
            AlbumItemHolder(it)
        }
    }

    override fun onBindViewHolder(holder: AlbumItemHolder, position: Int) {
        holder.bind(albumList[position])
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnAlbumItemClickListener {
        fun onItemClicked(tag: TopAlbumListModel.Albums.Album)
    }
}