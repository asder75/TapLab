package com.example.taplab

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.activityViewModels
import com.example.taplab.databinding.FragmentBlank2Binding
import com.example.taplab.databinding.FragmentDinoBinding


class DinoFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentDinoBinding

    private lateinit var webView : WebView
    private var url = "file:///android_asset/index.html"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDinoBinding.inflate(inflater)
        webView = binding.wv
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url)

        val img = binding.mobOne
        img.setBackgroundResource(R.drawable.run_anim)
        val newframeAnimation =  img.background as AnimationDrawable
        newframeAnimation.start()

        binding.exitbt.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.fragments.forEach { fragment ->
                    it.supportFragmentManager.beginTransaction().remove(fragment).commit()
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    companion object {
        @JvmStatic
        fun newInstance() = DinoFragment()
    }
}