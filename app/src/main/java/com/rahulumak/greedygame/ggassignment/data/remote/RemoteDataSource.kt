package com.rahulumak.greedygame.ggassignment.data.remote

import com.rahulumak.greedygame.ggassignment.model.*
interface RemoteDataSource {
    suspend fun getGenres(): GenreListModel
    suspend fun getGenreInfo(tag: String): GenreInfoModel
    suspend fun getTopAlbums(tag: String): TopAlbumListModel
    suspend fun getTopArtists(tag: String): TopArtistLisModel
    suspend fun getTopTracks(tag: String): TopTrackListModel
    suspend fun getAlbumInfo(album: String, artist: String): AlbumModel
    suspend fun getArtistInfo(artist: String): ArtistModel
}
