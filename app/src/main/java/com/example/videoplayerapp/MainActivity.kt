package com.example.videoplayerapp

import android.annotation.SuppressLint
import android.net.Uri
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
        val videoView: VideoView = findViewById(R.id.videoView)
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

        // recuperando videos da internet
        val videoView2: VideoView = findViewById(R.id.videoView2)

        // definindo url do video
        val uri: Uri = Uri.parse("https://static.videezy.com/system/resources/previews/000/002/231/original/5226496.mp4")

        // usando o videoView2 para acessar o setVideoUri e procurar retornar o video atraves do link
        videoView2.setVideoURI(uri)

        val mediaController2: MediaController = MediaController(this)

        // definindo controladores
        mediaController2.setAnchorView(videoView2)
        mediaController2.setMediaPlayer(videoView2)

        // setando controlador
        videoView2.setMediaController(mediaController2)

    }
}