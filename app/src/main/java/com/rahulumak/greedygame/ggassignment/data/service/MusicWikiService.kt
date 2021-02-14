package com.rahulumak.greedygame.ggassignment.data.service

import com.rahulumak.greedygame.ggassignment.config.ProjectConfig
import com.rahulumak.greedygame.ggassignment.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicWikiService {
    @GET("?method=${ProjectConfig.GET_GENRES_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getGenres(): GenreListModel

    @GET("?method=${ProjectConfig.GET_GENRES_INF_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getGenreInfo(
        @Query("tag") tag: String
    ): GenreInfoModel

    @GET("?method=${ProjectConfig.GET_TOP_ALBUMS_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getTopAlbums(
        @Query("tag") tag: String
    ): TopAlbumListModel

    @GET("?method=${ProjectConfig.GET_TOP_ARTIST_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getTopArtists(
        @Query("tag") tag: String
    ): TopArtistLisModel

    @GET("?method=${ProjectConfig.GET_TOP_TRACKS_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getTopTracks(
        @Query("tag") tag: String
    ): TopTrackListModel

    @GET("?method=${ProjectConfig.GET_ALBUM_INFO_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getAlbumInfo(
        @Query("album") album: String,
        @Query("artist") artist: String
    ): AlbumModel

    @GET("?method=${ProjectConfig.GET_ARTIST_INFO_METHOD}&api_key=${ProjectConfig.API_KEY}&format=${ProjectConfig.FORMAT}")
    suspend fun getArtistInfo(
        @Query("artist") artist: String
    ): ArtistModel
}