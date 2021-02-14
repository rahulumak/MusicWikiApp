package com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.greedygame.ggassignment.R
import com.rahulumak.greedygame.ggassignment.databinding.ItemAlbumBinding
import com.rahulumak.greedygame.ggassignment.databinding.ItemTrackBinding
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import com.rahulumak.greedygame.ggassignment.model.TopTrackListModel
import kotlinx.android.synthetic.main.item_genre.view.*

class TrackListAdapter : RecyclerView.Adapter<TrackListAdapter.TrackItemHolder>() {
    var trackList = listOf<TopTrackListModel.Tracks.Track>()
    var onTrackItemClickListener: OnTrackItemClickListener? = null

    inner class TrackItemHolder(private val binding: ItemTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TopTrackListModel.Tracks.Track) {
            binding.apply {
                track = item
            }

            binding.root.setOnClickListener {
                onTrackItemClickListener?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackItemHolder {
        return DataBindingUtil.inflate<ItemTrackBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_track,
            parent,
            false
        ).let {
            TrackItemHolder(it)
        }
    }

    override fun onBindViewHolder(holder: TrackItemHolder, position: Int) {
        holder.bind(trackList[position])
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnTrackItemClickListener {
        fun onItemClicked(tag: TopTrackListModel.Tracks.Track)
    }
}