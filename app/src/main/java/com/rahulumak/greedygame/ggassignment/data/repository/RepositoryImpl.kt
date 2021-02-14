package com.rahulumak.greedygame.ggassignment.data.repository

import com.rahulumak.greedygame.ggassignment.data.local.LocalDataSource
import com.rahulumak.greedygame.ggassignment.data.remote.RemoteDataSource
import com.rahulumak.greedygame.ggassignment.model.*

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getGenres(): GenreListModel {
        return remoteDataSource.getGenres()
    }

    override suspend fun getGenreInfo(tag: String): GenreInfoModel {
        return remoteDataSource.getGenreInfo(tag)
    }

    override suspend fun getTopAlbums(tag: String): TopAlbumListModel {
        return remoteDataSource.getTopAlbums(tag)
    }

    override suspend fun getTopArtists(tag: String): TopArtistLisModel {
        return remoteDataSource.getTopArtists(tag)
    }

    override suspend fun getTopTracks(tag: String): TopTrackListModel {
        return remoteDataSource.getTopTracks(tag)
    }

    override suspend fun getAlbumInfo(album: String, artist: String): AlbumModel {
        return remoteDataSource.getAlbumInfo(album, artist)
    }

    override suspend fun getArtistInfo(artist: String): ArtistModel {
        return remoteDataSource.getArtistInfo(artist)
    }

    override suspend fun getAllGenres(): List<GenreListModel.Toptags.Tag> {
        return localDataSource.getAllGenres()
    }

    override suspend fun saveGenres(genres: List<GenreListModel.Toptags.Tag>) {
        localDataSource.saveGenres(genres)
    }

    override suspend fun deleteAllGenres() {
        localDataSource.deleteAllGenres()
    }
}