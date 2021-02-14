package com.rahulumak.greedygame.ggassignment.model


import com.google.gson.annotations.SerializedName

data class TopTrackListModel(
    @SerializedName("tracks")
    val tracks: Tracks
) {
    data class Tracks(
        @SerializedName("@attr")
        val attr: Attr,
        @SerializedName("track")
        val track: List<Track>
    ) {
        data class Attr(
            @SerializedName("page")
            val page: String,
            @SerializedName("perPage")
            val perPage: String,
            @SerializedName("tag")
            val tag: String,
            @SerializedName("total")
            val total: String,
            @SerializedName("totalPages")
            val totalPages: String
        )

        data class Track(
            @SerializedName("artist")
            val artist: Artist,
            @SerializedName("@attr")
            val attr: Attr,
            @SerializedName("duration")
            val duration: String,
            @SerializedName("image")
            val image: List<Image>,
            @SerializedName("mbid")
            val mbid: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("streamable")
            val streamable: Streamable,
            @SerializedName("url")
            val url: String
        ) {
            data class Artist(
                @SerializedName("mbid")
                val mbid: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("url")
                val url: String
            )

            data class Attr(
                @SerializedName("rank")
                val rank: String
            )

            data class Image(
                @SerializedName("size")
                val size: String,
                @SerializedName("#text")
                val text: String
            )

            data class Streamable(
                @SerializedName("fulltrack")
                val fulltrack: String,
                @SerializedName("#text")
                val text: String
            )
        }
    }
}