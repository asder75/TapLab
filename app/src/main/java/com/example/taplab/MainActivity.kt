package com.example.taplab

import android.R.id
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.taplab.databinding.ActivityMainBinding
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(binding.root)


        val img = binding.spinningWheelImage
        img.setBackgroundResource(R.drawable.spin_animation)
        val frameAnimation = img.background as AnimationDrawable
        frameAnimation.start();

        val mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);
        img.startAnimation(mEnlargeAnimation);

        val textlogo = binding.textLogo
        val mTextLogoAnimation = AnimationUtils.loadAnimation(this, R.anim.alphanim);
        textlogo.startAnimation(mTextLogoAnimation);

        val startBt = binding.nextButton
        val trailerBt = binding.trailerButton
        val exitBt = binding.exitbt
        val intent = Intent(this, TitleActivity::class.java)

        val videoView : VideoView = binding.videoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val offlineUri : Uri = Uri.parse("android.resource://$packageName/${R.raw.trailer}")
        videoView.setVisibility(View.INVISIBLE);

        val bgVideo = binding.bgnew2


        startBt.setOnClickListener {
            startActivity(intent)
        }
        trailerBt.setOnClickListener {
            exitBt.setVisibility(View.VISIBLE);
            bgVideo.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.VISIBLE);
            videoView.setMediaController((mediaController))
            videoView.setVideoURI(offlineUri)
            videoView.requestFocus()
            videoView.start()
        }
        exitBt.setOnClickListener {
            videoView.stopPlayback()
            exitBt.setVisibility(View.INVISIBLE);
            bgVideo.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.INVISIBLE);
        }

    }

}
