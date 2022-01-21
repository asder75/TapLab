package com.example.taplab

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.taplab.databinding.FragmentAchBinding
import com.example.taplab.databinding.FragmentBlank2Binding

class AchFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentAchBinding

    private var myStrPriceOne: String? = null
    private var myStrPriceTwo: String? = null
    private var myStrPriceThree: String? = null


    private var myGold: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAchBinding.inflate(inflater)
        val data = arguments
        if (data != null) {
            myStrPriceOne = data.getString("myDataPriceOneMan")
            myStrPriceTwo = data.getString("myDataPriceTwoMan")
            myStrPriceThree = data.getString("myDataPriceThreeMan")


            myGold = data.getString("myDataGold")
        }
        binding.priceOne.setText(myStrPriceOne)
        binding.priceTwo.setText(myStrPriceTwo)
        binding.priceThree.setText(myStrPriceThree)
        binding.goldreal.setText(myGold)

        binding.exitShop.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.fragments.forEach { fragment ->
                    it.supportFragmentManager.beginTransaction().remove(fragment).commit()
                }
            }
        }


       fun TextChange() {
    binding.textView.setTextColor(Color.WHITE);
    binding.textView.setShadowLayer(3.6f, 3.5f, 3.3f, Color.BLACK);
    binding.textView2.setTextColor(Color.WHITE);
    binding.textView2.setShadowLayer(3.6f, 3.5f, 3.3f, Color.BLACK);
    binding.textView3.setTextColor(Color.WHITE);
    binding.textView3.setShadowLayer(3.6f, 3.5f, 3.3f, Color.BLACK);
    binding.goldreal.setTextColor(Color.WHITE);
    binding.goldreal.setShadowLayer(3.6f, 3.5f, 3.3f, Color.BLACK);
    binding.damageplus1.setTextColor(Color.WHITE);
    binding.damageplus1.setShadowLayer(2.6f, 2.5f, 2.3f, Color.BLACK);
    binding.damageplus2.setTextColor(Color.WHITE);
    binding.damageplus2.setShadowLayer(2.6f, 2.5f, 2.3f, Color.BLACK);
    binding.damageplus3.setTextColor(Color.WHITE);
    binding.damageplus3.setShadowLayer(2.6f, 2.5f, 2.3f, Color.BLACK);
}
        TextChange()
        return binding.root
    }
    fun DataCheck(){
        val data = arguments
        if (data != null) {
            myStrPriceOne = data.getString("myDataPriceOneMan")
            myStrPriceTwo = data.getString("myDataPriceTwoMan")
            myStrPriceThree = data.getString("myDataPriceThreeMan")

            myGold = data.getString("myDataGold")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buySwordOne.setOnClickListener {
            (activity as? Listener)?.onPressButtonClickBuyMan()
            DataCheck()
            binding.priceOne.setText(myStrPriceOne)
            binding.goldreal.setText(myGold)
        }
        binding.buySwordTwo.setOnClickListener {
            (activity as? ListenerTwo)?.onPressButtonClickBuyTwoMan()
            DataCheck()
            binding.priceTwo.setText(myStrPriceTwo)
            binding.goldreal.setText(myGold)
        }
        binding.buySwordThree.setOnClickListener {
            (activity as? ListenerThree)?.onPressButtonClickBuyThreeMan()
            DataCheck()
            binding.priceThree.setText(myStrPriceThree)
            binding.goldreal.setText(myGold)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = AchFragment()
    }

    interface Listener {
        fun onPressButtonClickBuyMan()
    }
    interface ListenerTwo {
        fun onPressButtonClickBuyTwoMan()
    }
    interface ListenerThree {
        fun onPressButtonClickBuyThreeMan()
    }
}