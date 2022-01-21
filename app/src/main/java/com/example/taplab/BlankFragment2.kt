package com.example.taplab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.taplab.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {
private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding = FragmentBlank2Binding.inflate(inflater)
        binding.exitbt.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.fragments.forEach { fragment ->
                    it.supportFragmentManager.beginTransaction().remove(fragment).commit()
                    it.supportFragmentManager.beginTransaction().replace(R.id.place_holder2, BlankFragment3.newInstance()).commit()
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.removeWorldBt.setOnClickListener {
            dataModel.message.value = "1"
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}