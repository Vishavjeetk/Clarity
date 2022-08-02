package com.example.spotify.repository

import com.example.spotify.R
import com.example.spotify.model.Song

class songRepository {

    fun getAllData(): List<Song>{
        return listOf(
            Song(
                title = "What Do You Mean",
                artist = "MarshMellow",
                imageUrl = R.drawable.annemarie1,
                audioUrl = R.raw.whatdoyoumean
            ),
            Song(
                title = "Rise",
                artist = "Brandon",
                imageUrl = R.drawable.logo,
                audioUrl = R.raw.song
            ),
            Song(
                title = "Im The One",
                artist = "MarshMellow",
                imageUrl = R.drawable.marshmellow,
                audioUrl = R.raw.djsnake
            ),
            Song(
                title = "Blocks",
                artist = "MarshMellow",
                imageUrl = R.drawable.annemarie,
                audioUrl = R.raw.imtheone
            ),
            Song(
                title = "What Do You Mean",
                artist = "Justin Bieber",
                imageUrl = R.drawable.djsnake,
                audioUrl = R.raw.djsnake
            ),
            Song(
                title = "2002",
                artist = "Anne Marie",
                imageUrl = R.drawable.djsnake1,
                audioUrl = R.raw.imtheone
            ),
            Song(
                title = "Blessed",
                artist = "Jupiter",
                imageUrl = R.drawable.annemarie1,
                audioUrl = R.raw.djsnake
            ),
            Song(
                title = "Ride",
                artist = "Twenty One Pilots",
                imageUrl = R.drawable.logo,
                audioUrl = R.raw.song
            ),
            Song(
                title = "Blocks",
                artist = "MarshMellow",
                imageUrl = R.drawable.marshmellow,
                audioUrl = R.raw.whatdoyoumean
            ),
            Song(
                title = "Heathens",
                artist = "Twenty One Pilots",
                imageUrl = R.drawable.annemarie,
                audioUrl = R.raw.imtheone
            ),
            Song(
                title = "How Could This",
                artist = "Jake Paul",
                imageUrl = R.drawable.djsnake,
                audioUrl = R.raw.djsnake
            ),
            Song(
                title = "Chlorine",
                artist = "Twenty One Pilots",
                imageUrl = R.drawable.djsnake1,
                audioUrl = R.raw.whatdoyoumean
            )
        )
    }
}