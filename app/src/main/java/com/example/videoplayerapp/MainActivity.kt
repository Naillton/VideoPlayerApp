package com.example.videoplayerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recuperando videos do local storage
        val videoView: VideoView = findViewById(R.id.videoView1)
        // para acessar o video no local storage temos que especificar a pasta de destino
        // do nosso arquivo em seguida definimos o pacote e depois o nome do arquivo presente na pasta
        videoView.setVideoPath("android.resource://"+packageName+"/"+R.raw.mountains)

        // criando um controlador de media passando como parametro o context atual
        val mediaController: MediaController = MediaController(this)

        // definindo arcoragem do video e setando o MediaPlayer
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)

        // setando o controlador de media no na view do video
        videoView.setMediaController(mediaController)
    }
}