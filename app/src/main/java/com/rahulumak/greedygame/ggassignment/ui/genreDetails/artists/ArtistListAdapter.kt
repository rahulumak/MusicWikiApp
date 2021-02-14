package com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ItemAlbumBinding
import com.rahulumak.greedygame.ggassignment.databinding.ItemArtistBinding
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel


class ArtistListAdapter : RecyclerView.Adapter<ArtistListAdapter.ArtistItemHolder>() {
    var artistList = listOf<TopArtistLisModel.Topartists.Artist>()
    var onArtistItemClickListener: OnArtistItemClickListener? = null

    inner class ArtistItemHolder(private val binding: ItemArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TopArtistLisModel.Topartists.Artist) {
            binding.apply {
                artist = item
            }

            binding.root.setOnClickListener {
                onArtistItemClickListener?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistItemHolder {
        return DataBindingUtil.inflate<ItemArtistBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_artist,
            parent,
            false
        ).let {
            ArtistItemHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ArtistItemHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnArtistItemClickListener {
        fun onItemClicked(tag: TopArtistLisModel.Topartists.Artist)
    }
}