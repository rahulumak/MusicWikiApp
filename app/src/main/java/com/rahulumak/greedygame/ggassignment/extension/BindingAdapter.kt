package com.rahulumak.greedygame.ggassignment.extension

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.rahulumak.greedygame.ggassignment.model.GenreListModel
import com.rahulumak.greedygame.ggassignment.model.TopAlbumListModel
import com.rahulumak.greedygame.ggassignment.model.TopArtistLisModel
import com.rahulumak.greedygame.ggassignment.model.TopTrackListModel
import com.rahulumak.greedygame.ggassignment.ui.albumDetails.TagAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.albums.AlbumListAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.artists.ArtistListAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreDetails.tracks.TrackListAdapter
import com.rahulumak.greedygame.ggassignment.ui.genreList.GenreListAdapter

import kotlin.math.ceil


@BindingAdapter("bind:loadUrl")
fun bindUrlImage(view: ImageView, url: String?) {
    url?.apply {
        Glide.with(view)
            .load(url)
            .into(view)
    }

}

@BindingAdapter("bind:toSmallDate")
fun bindToSmallDate(view: TextView, date: Long) {
    try {
        view.text = Converters.toSmallDate(date)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}


@BindingAdapter("bind:bindIntText")
fun bindIntText(view: TextView, value: Int?) {
    value?.apply {
        view.text = value.toString()
    }

}


@BindingAdapter("bind:show")
fun show(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bind:humidityText")
fun humidityText(view: TextView, value: Int) {
    view.text = "${value}%"

}

@BindingAdapter("bind:windText")
fun txtWindText(view: TextView, value: Double) {
    view.text = "${value} km/h"

}


@BindingAdapter("bind:loadWeatherIcon")
fun loadWeatherIcon(view: ImageView, icon: String?) {
    icon?.apply {
        Glide.with(view)
            .load("http://openweathermap.org/img/wn/$icon@2x.png")
            .circleCrop()
            .into(view)
    }
}

@BindingAdapter("bind:genreItems")
fun genreItems(view: RecyclerView, items: List<GenreListModel.Toptags.Tag>?) {
    items?.apply {
        view.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val genreListAdapter = view.adapter as GenreListAdapter
        genreListAdapter.itemList = items
        genreListAdapter.notifyDataSetChanged()
    }
}

@BindingAdapter("bind:albumItems")
fun albumItems(view: RecyclerView, items: List<TopAlbumListModel.Albums.Album>?) {
    items?.apply {
        view.layoutManager = GridLayoutManager(view.context,2, GridLayoutManager.VERTICAL,false)
        val albumListAdapter = view.adapter as AlbumListAdapter
        albumListAdapter.albumList = items
        albumListAdapter.notifyDataSetChanged()
    }
}
@BindingAdapter("bind:artistItems")
fun artistItems(view: RecyclerView, items: List<TopArtistLisModel.Topartists.Artist>?) {
    items?.apply {
        view.layoutManager = GridLayoutManager(view.context,2, GridLayoutManager.VERTICAL,false)
        val albumListAdapter = view.adapter as ArtistListAdapter
        albumListAdapter.artistList = items
        albumListAdapter.notifyDataSetChanged()
    }
}
@BindingAdapter("bind:trackItems")
fun trackItems(view: RecyclerView, items: List<TopTrackListModel.Tracks.Track>?) {
    items?.apply {
        view.layoutManager = GridLayoutManager(view.context,2, GridLayoutManager.VERTICAL,false)
        val albumListAdapter = view.adapter as TrackListAdapter
        albumListAdapter.trackList = items
        albumListAdapter.notifyDataSetChanged()
    }
}
@BindingAdapter("bind:tagItems")
fun tagItems(view: RecyclerView, items: List<GenreListModel.Toptags.Tag>?) {
    items?.apply {
        view.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
        val albumListAdapter = view.adapter as TagAdapter
        albumListAdapter.genreList = items
        albumListAdapter.notifyDataSetChanged()
    }
}