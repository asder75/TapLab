package com.example.taplab

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taplab.databinding.FragmentShopBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ShopFragment : Fragment() {
    lateinit var binding: FragmentShopBinding
    val database = Firebase.database
    private val dataModel: DataModel by viewModels()

    var buyItemOneOrNo : Int? = 4
    var stringBuyItemOne : String? = ""

    private var myStrPriceOne: String? = null
    private var myStrPriceTwo: String? = null
    private var myStrPriceThree: String? = null
    private var myStrPriceFo: String? = null
    private var myStrPriceFive: String? = null

    private var myGold: String? = null

    private var myStrPriceLoad: String? = null

    companion object {


        @JvmStatic
        fun newInstance() = ShopFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentShopBinding.inflate(inflater)


        val data = arguments
        if (data != null) {
            myStrPriceOne = data.getString("myDataPriceOne")
            myStrPriceTwo = data.getString("myDataPriceTwo")
            myStrPriceThree = data.getString("myDataPriceThree")
            myStrPriceFo = data.getString("myDataPriceFo")
            myStrPriceFive = data.getString("myDataPriceFive")
            myGold = data.getString("myDataGold")
        }
        binding.priceOne.setText(myStrPriceOne)
        binding.priceTwo.setText(myStrPriceTwo)
        binding.priceThree.setText(myStrPriceThree)
        binding.priceFo.setText(myStrPriceFo)
        binding.priceFive.setText(myStrPriceFive)
        binding.goldreal.setText(myGold)

        binding. goldreal.setTextColor(Color.WHITE);
        binding. goldreal.setShadowLayer(3.6f,3.5f,3.3f, Color.BLACK);

        binding.exitShop.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.fragments.forEach { fragment ->
                    it.supportFragmentManager.beginTransaction().remove(fragment).commit()
                }
            }
        }

        //val bundle = arguments
        //val message = bundle!!.getString("message")
        //binding.priceOne.text = message



    return binding.root
    }

    fun DataCheck(){
           val data = arguments
           if (data != null) {
               myStrPriceOne = data.getString("myDataPriceOne")
               myStrPriceTwo = data.getString("myDataPriceTwo")
               myStrPriceThree = data.getString("myDataPriceThree")
               myStrPriceFo = data.getString("myDataPriceFo")
               myStrPriceFive = data.getString("myDataPriceFive")
               myGold = data.getString("myDataGold")
           }
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val songClick: MediaPlayer = MediaPlayer.create(getActivity(), R.raw.click_sound)

        binding.buySwordOne.setOnClickListener {
            (activity as? Listener)?.onPressButtonClickBuy()
            DataCheck()
            binding.priceOne.setText(myStrPriceOne)
            binding.goldreal.setText(myGold)
            songClick.start()
        }
        binding.buySwordTwo.setOnClickListener {
            (activity as? ListenerTwo)?.onPressButtonClickBuyTwo()
            DataCheck()
            binding.priceTwo.setText(myStrPriceTwo)
            binding.goldreal.setText(myGold)
            songClick.start()
        }
        binding.buySwordThree.setOnClickListener {
            (activity as? ListenerThree)?.onPressButtonClickBuyThree()
            DataCheck()
            binding.priceThree.setText(myStrPriceThree)
            binding.goldreal.setText(myGold)
            songClick.start()
        }
        binding.buySwordFo.setOnClickListener {
            (activity as? ListenerFo)?.onPressButtonClickBuyFo()
            DataCheck()
            binding.priceFo.setText(myStrPriceFo)
            binding.goldreal.setText(myGold)
            songClick.start()
        }
        binding.buySwordFive.setOnClickListener {
            (activity as? ListenerFive)?.onPressButtonClickBuyFive()
            DataCheck()
            binding.priceFive.setText(myStrPriceFive)
            binding.goldreal.setText(myGold)
            songClick.start()
        }


    }
    interface Listener {
        fun onPressButtonClickBuy()
    }
    interface ListenerTwo {
        fun onPressButtonClickBuyTwo()
    }
    interface ListenerThree {
        fun onPressButtonClickBuyThree()
    }
    interface ListenerFo {
        fun onPressButtonClickBuyFo()
    }
    interface ListenerFive {
        fun onPressButtonClickBuyFive()
    }





}