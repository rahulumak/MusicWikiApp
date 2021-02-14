package com.rahulumak.greedygame.ggassignment.data.repository

import com.rahulumak.greedygame.ggassignment.model.*

interface Repository {
    suspend fun getGenres(): GenreListModel
    suspend fun getGenreInfo(tag: String): GenreInfoModel
    suspend fun getTopAlbums(tag: String): TopAlbumListModel
    suspend fun getTopArtists(tag: String): TopArtistLisModel
    suspend fun getTopTracks(tag: String): TopTrackListModel
    suspend fun getAlbumInfo(album: String, artist: String): AlbumModel
    suspend fun getArtistInfo(artist: String): ArtistModel

    suspend fun getAllGenres(): List<GenreListModel.Toptags.Tag>

    suspend fun saveGenres(genres: List<GenreListModel.Toptags.Tag>)

    suspend fun deleteAllGenres()
}