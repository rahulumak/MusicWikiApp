package com.rahulumak.greedygame.ggassignment.data.remote

import com.rahulumak.greedygame.ggassignment.data.service.MusicWikiService
import com.rahulumak.greedygame.ggassignment.model.*


class RemoteDataSourceImpl(private val musicWikiService: MusicWikiService) : RemoteDataSource {
    override suspend fun getGenres(): GenreListModel {
        return musicWikiService.getGenres()
    }

    override suspend fun getGenreInfo(tag: String): GenreInfoModel {
        return musicWikiService.getGenreInfo(tag)
    }

    override suspend fun getTopAlbums(tag: String): TopAlbumListModel {
        return musicWikiService.getTopAlbums(tag)
    }

    override suspend fun getTopArtists(tag: String): TopArtistLisModel {
        return musicWikiService.getTopArtists(tag)
    }

    override suspend fun getTopTracks(tag: String): TopTrackListModel {
        return musicWikiService.getTopTracks(tag)
    }

    override suspend fun getAlbumInfo(album: String, artist: String): AlbumModel {
        return musicWikiService.getAlbumInfo(album,artist)
    }

    override suspend fun getArtistInfo(artist: String): ArtistModel {
        return musicWikiService.getArtistInfo(artist)
    }

}