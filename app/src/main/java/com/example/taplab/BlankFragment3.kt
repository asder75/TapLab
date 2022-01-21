package com.example.taplab

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.taplab.databinding.FragmentBlank2Binding
import com.example.taplab.databinding.FragmentBlank3Binding


class BlankFragment3 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank3Binding

    lateinit var img : ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentBlank3Binding.inflate(inflater)
        binding.llTop.setOnDragListener(dragListener)


        img = binding.explosOne


        binding.bomb.setOnLongClickListener {
            val clipText = "yyyeeess"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
        return binding.root

    }



    val dragListener = View.OnDragListener {view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text

                img.setVisibility(View.VISIBLE);

                dataModel.message.value = "2"



                img.setBackgroundResource(R.drawable.explosion_anim)
                val frameAnimation = img.background as AnimationDrawable
                frameAnimation.start()

                val handler = Handler()
                handler.postDelayed({
                    binding.bomb.setVisibility(View.INVISIBLE);
                }, 100)
                handler.postDelayed({
                    frameAnimation.stop()
                    img.setVisibility(View.INVISIBLE);
                }, 306)
                handler.postDelayed({
                    binding.bomb.setVisibility(View.VISIBLE);
                }, 7000)


                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)
                val destination = view as ConstraintLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false

        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment3()
    }
}