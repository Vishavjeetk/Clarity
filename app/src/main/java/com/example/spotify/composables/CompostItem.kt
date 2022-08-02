package com.example.spotify.composables

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotify.model.Song

@Composable
fun CompostItem(
    song: Song,
    mp: MediaPlayer = MediaPlayer(),
    play: Int,
    pause: Int,
) {
    var state by remember {
        mutableStateOf(value = false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        ) {
            Image(
                painter = painterResource(id = song.imageUrl),
                contentDescription = "HELLO",
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(text = song.title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = song.artist)

            }
            if (state) {
                Image(painter = painterResource(id = pause), contentDescription = "Yes",
                    modifier = Modifier
                        .clickable {
                            state = if (!mp.isPlaying) {
                                mp.start()
                                !state

                            } else {
                                mp.pause()
                                !state

                            }
                        }
                        .width(30.dp)
                        .height(30.dp)
                )
            } else {
                Image(painter = painterResource(id = play), contentDescription = "Yes",
                    modifier = Modifier
                        .clickable {
                            state = if (!mp.isPlaying) {
                                mp.start()
                                !state

                            } else {
                                mp.pause()
                                !state
                            }
                        }
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
    }
}