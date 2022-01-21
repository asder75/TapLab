package com.example.taplab

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.taplab.databinding.ActivityTitleBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Context
import android.content.Intent


class TitleActivity : AppCompatActivity(), ShopFragment.Listener, ShopFragment.ListenerTwo, ShopFragment.ListenerThree, ShopFragment.ListenerFo, ShopFragment.ListenerFive,
        AchFragment.Listener,AchFragment.ListenerTwo,AchFragment.ListenerThree {
    private lateinit var binding: ActivityTitleBinding
    private val dataModel: DataModel by viewModels()

    var hp : Int? = 5
    var hpMax : Int? = 5
    var money : Int? = 0
    var lvlThis : Int? = 1
    var killMobs : Int? = 0
    var damage : Int? = 1

    var useBomb : Int? = 0
    var bombAttack : Int? = 0
    var removeWorld : Int? = 0

    var price_item_1 : Int? = 4
    var price_item_2 : Int? = 24
    var price_item_3 : Int? = 100
    var price_item_4 : Int? = 333
    var price_item_5 : Int? = 1200

    var price_man_1 : Int? = 50
    var price_man_2 : Int? = 150
    var price_man_3 : Int? = 450

    var damage_mans_1 : Int? = 0

    var reloadAnimNew : Boolean = false

    val database = Firebase.database
    val myRefHp = database.getReference("hp_mob_ac_2")
    val myRefMaxHp = database.getReference("max_hp_mob_ac_2")
    val myRefMoney = database.getReference("money")
    val myRefLvlThis = database.getReference("level_this")
    val myRefKillMobs = database.getReference("kill_mobs")
    val myRefDamage = database.getReference("damage")
    val myRefUseBomb = database.getReference("use_bomb")
    val myRefPriceItemOne = database.getReference("price_item_1")
    val myRefPriceItemTwo = database.getReference("price_item_2")
    val myRefPriceItemThree = database.getReference("price_item_3")
    val myRefPriceItemFo = database.getReference("price_item_4")
    val myRefPriceItemFive = database.getReference("price_item_5")
    val myRefPriceManOne = database.getReference("price_man_1")
    val myRefPriceManTwo = database.getReference("price_man_2")
    val myRefPriceManThree = database.getReference("price_man_3")
    val myRefDamageManOne = database.getReference("damage_mans_1")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.place_holder2, BlankFragment3.newInstance()).commit()

        onChangedListener(myRefHp)
        onChangedListenerMoney(myRefMoney)
        onChangedListenerMaxHp(myRefMaxHp)
        onChangedListenerLvlThis(myRefLvlThis)
        onChangedListenerKillMobs(myRefKillMobs)
        onChangedListenerDamage(myRefDamage)
        onChangedListenerUseBomb(myRefUseBomb)
        onChangedListenerPriceItemOne(myRefPriceItemOne)
        onChangedListenerPriceItemTwo(myRefPriceItemTwo)
        onChangedListenerPriceItemThree(myRefPriceItemThree)
        onChangedListenerPriceItemFo(myRefPriceItemFo)
        onChangedListenerPriceItemFive(myRefPriceItemFive)
        onChangedListenerPriceManOne(myRefPriceManOne)
        onChangedListenerPriceManTwo(myRefPriceManTwo)
        onChangedListenerPriceManThree(myRefPriceManThree)
        onChangedListenerDamageManOne(myRefDamageManOne)


        val songAttack: MediaPlayer = MediaPlayer.create(this, R.raw.dager_sound)
        val songClick: MediaPlayer = MediaPlayer.create(this, R.raw.click_sound)
        val songBomb: MediaPlayer = MediaPlayer.create(this, R.raw.expl_sound)
        val songLevelUp : MediaPlayer = MediaPlayer.create(this, R.raw.levelupsound)
        val menuSound  : MediaPlayer = MediaPlayer.create(this, R.raw.mainsong)

        val img = binding.mobOne
        img.setBackgroundResource(R.drawable.mob_one_anim)
        val backgroundImg = binding.bgtitle
        //val frameAnimation = img.background as AnimationDrawable

        val handler = Handler()
        val settingBt = binding.setBt
        val shopBt = binding.shopBt
        val manBt = binding.achBt
        val dinoBt = binding.dinoBt

        val mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.largeonetwo)
        var animationReload  = 0

        val screenHandler = Handler(Looper.getMainLooper())


        fun ChangeAnims(){
            if(lvlThis!! % 5 != 0) {
                if (killMobs == 0) {
                    img.setBackgroundResource(R.drawable.mob_one_anim)
                }
                if (killMobs == 1) {
                    img.setBackgroundResource(R.drawable.mob_two_anim)
                }
                if (killMobs == 2) {
                    img.setBackgroundResource(R.drawable.mob_three_anim)
                }
                if (killMobs == 3) {
                    img.setBackgroundResource(R.drawable.mob_fo_anim)
                }
                if (killMobs == 4) {
                    img.setBackgroundResource(R.drawable.mob_five_anim)
                }
                if (killMobs == 5) {
                    img.setBackgroundResource(R.drawable.mob_seven_anim)
                }
                if (killMobs == 6) {
                    img.setBackgroundResource(R.drawable.mob_six_anim)
                }
                if (killMobs == 7) {
                    img.setBackgroundResource(R.drawable.mon_ate_anim)
                }
                if (killMobs == 8) {
                    img.setBackgroundResource(R.drawable.mob_nine_anim)
                }
                if (killMobs == 9) {
                    img.setBackgroundResource(R.drawable.mob_ten_anim)
                }
            }
            else{
                img.setBackgroundResource(R.drawable.nig_anim)
            }
        }
        fun ChangeBg(){
            if(lvlThis!! % 5 == 0){
                backgroundImg.setBackgroundResource(R.drawable.pixnightbg)
            }
            else{
                backgroundImg.setBackgroundResource(R.drawable.bg_pokmn)
            }
        }
        fun OnAttack(){
            songAttack.start();
             if(bombAttack == 0){
                     hp = hp!! - damage!!
             }
            if(bombAttack == 1){
                hp = 1
                songBomb.start();
                bombAttack = 0
            }
            myRefHp.setValue(hp.toString())

            if(hp!! <= 0){
                ChangeAnims()
                ChangeBg()
                if(lvlThis!! % 5 != 0) {
                    money = money!! + 1
                }
                else{
                    money = money!! + 2
                }
                myRefMoney.setValue(money.toString())

                hp = hp!! + hpMax!!
                myRefHp.setValue(hp.toString())

                killMobs = killMobs!! + 1
                myRefKillMobs.setValue(killMobs.toString())

                if(killMobs == 10){
                    hpMax = hpMax!! + 1
                    myRefMaxHp.setValue(hpMax.toString())

                    killMobs = 0
                    myRefKillMobs.setValue(killMobs.toString())

                    lvlThis = lvlThis!! + 1
                    myRefLvlThis.setValue(lvlThis.toString())

                    songLevelUp.start()
                }

            }
            if(reloadAnimNew == false) {
                reloadAnimNew = true
            }


        }
        fun OnAttackManOne(){
            screenHandler.post(object: Runnable{
                override fun run() {
                    hp = hp!! - damage_mans_1!!
                    myRefHp.setValue(hp.toString())

                    if(hp!! <= 0){
                        ChangeAnims()
                        ChangeBg()
                        if(lvlThis!! % 5 != 0) {
                            money = money!! + 1
                        }
                        else{
                            money = money!! + 2
                        }
                        myRefMoney.setValue(money.toString())

                        hp = hp!! + hpMax!!
                        myRefHp.setValue(hp.toString())

                        killMobs = killMobs!! + 1
                        myRefKillMobs.setValue(killMobs.toString())

                        if(killMobs == 10){
                            hpMax = hpMax!! + 1
                            myRefMaxHp.setValue(hpMax.toString())

                            killMobs = 0
                            myRefKillMobs.setValue(killMobs.toString())

                            lvlThis = lvlThis!! + 1
                            myRefLvlThis.setValue(lvlThis.toString())
                        }
                    }

                    screenHandler.postDelayed(this, 1000)
                }
            })

        }
        fun PlayAnims(){


            screenHandler.post(object: Runnable{
                override fun run() {
                    if(reloadAnimNew == true )
                    {
                        val newframeAnimation =  img.background as AnimationDrawable

                        if(animationReload == 0) {

                            newframeAnimation.start()
                            animationReload = 1
                            //471
                        }

                        if(animationReload == 1) {
                            handler.postDelayed({

                                newframeAnimation.stop()
                                animationReload = 0
                                reloadAnimNew = false
                            }, 451)
                        }
                    }
                    screenHandler.postDelayed(this, 150)
                }
            })

        }
        ChangeAnims()
        ChangeBg()
        OnAttackManOne()
        PlayAnims()

        img.setOnClickListener {
            OnAttack()
        }
        settingBt.setOnClickListener {
            songClick.start();
            supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment2.newInstance()).commit()
        }
        shopBt.setOnClickListener {
            songClick.start();
            GetPriceItems()
        }
        manBt.setOnClickListener {
            songClick.start();
            GetPriceMans()
        }
        dinoBt.setOnClickListener {
            val dinoFragment = DinoFragment()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.place_holder_dino, dinoFragment).commit();
        }


        dataModel.message.observe(this, {
            removeWorld = it.toString().toInt()

            if (removeWorld == 1) {
                myRefHp.setValue(5.toString())
                myRefDamage.setValue(1.toString())
                myRefMoney.setValue(0.toString())
                myRefMaxHp.setValue(5.toString())
                myRefKillMobs.setValue(0.toString())
                myRefLvlThis.setValue(1.toString())

                myRefPriceItemOne.setValue(4.toString())
                myRefPriceItemTwo.setValue(24.toString())
                myRefPriceItemThree.setValue(100.toString())
                myRefPriceItemFo.setValue(333.toString())
                myRefPriceItemFive.setValue(1200.toString())

                myRefPriceManOne.setValue(50.toString())
                myRefPriceManTwo.setValue(150.toString())
                myRefPriceManThree.setValue(450.toString())

                myRefDamageManOne.setValue(0.toString())

                removeWorld = 0
            }
            if (removeWorld == 2) {

                bombAttack = 1
                OnAttack()
                removeWorld = 0
            }



        })

    }

    fun GetPriceItems(){
        val shopFragment = ShopFragment()

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val data = Bundle()
        data.putString("myDataPriceOne", "$price_item_1")
        data.putString("myDataPriceTwo", "$price_item_2")
        data.putString("myDataPriceThree", "$price_item_3")
        data.putString("myDataPriceFo", "$price_item_4")
        data.putString("myDataPriceFive", "$price_item_5")
        data.putString("myDataGold", "$money")

        shopFragment.setArguments(data)
        fragmentTransaction.replace(R.id.place_holder3, shopFragment).commit();

    }
    fun GetPriceMans(){
        val manFragment = AchFragment()

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val data = Bundle()
        data.putString("myDataPriceOneMan", "$price_man_1")
        data.putString("myDataPriceTwoMan", "$price_man_2")
        data.putString("myDataPriceThreeMan", "$price_man_3")
        data.putString("myDataGold", "$money")


        manFragment.setArguments(data)
        fragmentTransaction.replace(R.id.place_holder3, manFragment).commit();

    }

    private fun BuyItemOne(){
        if(money!! >= price_item_1!!){
            money = money!! - price_item_1!!
            damage = damage!! + 1
            price_item_1 = price_item_1!! + 4

            myRefPriceItemOne.setValue(price_item_1.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

            //songClick.start();

            GetPriceItems()
        }
    }
    private fun BuyItemTwo(){
        if(money!! >= price_item_2!!){
            money = money!! - price_item_2!!
            damage = damage!! + 2
            price_item_2 = price_item_2!! + 24

            myRefPriceItemTwo.setValue(price_item_2.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

            //songClick.start();

            GetPriceItems()
        }
    }
    private fun BuyItemThree(){
        if(money!! >= price_item_3!!){
            money = money!! - price_item_3!!
            damage = damage!! + 3
            price_item_3 = price_item_3!! + 100

            myRefPriceItemThree.setValue(price_item_3.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

            //songClick.start();

            GetPriceItems()
        }
    }
    private fun BuyItemFo(){
        if(money!! >= price_item_4!!){
            money = money!! - price_item_4!!
            damage = damage!! + 5
            price_item_4 = price_item_4!! + 333

            myRefPriceItemFo.setValue(price_item_4.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

           // songClick.start();

            GetPriceItems()
        }
    }
    private fun BuyItemFive(){
        if(money!! >= price_item_5!!){
            money = money!! - price_item_5!!
            damage = damage!! + 5
            price_item_5 = price_item_5!! + 1200

            myRefPriceItemFive.setValue(price_item_5.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

          //  songClick.start();

            GetPriceItems()
        }
    }

    private fun BuyManOne(){
        if(money!! >= price_man_1!!){
            money = money!! - price_man_1!!
            //damage = damage!! + 1 to chto budet posle pokupki
            price_man_1 = price_man_1!! + 50
            damage_mans_1 = damage_mans_1!! + 1
            myRefDamageManOne.setValue(damage_mans_1.toString())

            myRefPriceManOne.setValue(price_man_1.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

         //   songClick.start();

            GetPriceMans()
        }
    }
    private fun BuyManTwo(){
        if(money!! >= price_man_2!!){
            money = money!! - price_man_2!!
            //damage = damage!! + 1 to chto budet posle pokupki
            price_man_2 = price_man_2!! + 150

            damage_mans_1 = damage_mans_1!! + 2
            myRefDamageManOne.setValue(damage_mans_1.toString())

            myRefPriceManTwo.setValue(price_man_2.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

          //  songClick.start();

            GetPriceMans()
        }
    }
    private fun BuyManThree(){
        if(money!! >= price_man_3!!){
            money = money!! - price_man_3!!
            //damage = damage!! + 1 to chto budet posle pokupki
            price_man_3 = price_man_3!! + 450

            damage_mans_1 = damage_mans_1!! + 3
            myRefDamageManOne.setValue(damage_mans_1.toString())

            myRefPriceManThree.setValue(price_man_3.toString())
            myRefMoney.setValue(money.toString())
            myRefDamage.setValue(damage.toString())

         //   songClick.start();

            GetPriceMans()
        }
    }

    override fun onPressButtonClickBuy() {
        BuyItemOne()
    }
    override fun onPressButtonClickBuyTwo() {
        BuyItemTwo()
    }
    override fun onPressButtonClickBuyThree() {
        BuyItemThree()
    }
    override fun onPressButtonClickBuyFo() {
        BuyItemFo()
    }
    override fun onPressButtonClickBuyFive() {
        BuyItemFive()
    }

    override fun onPressButtonClickBuyMan() {
        BuyManOne()
    }
    override fun onPressButtonClickBuyTwoMan() {
        BuyManTwo()
    }
    override fun onPressButtonClickBuyThreeMan() {
        BuyManThree()
    }

    private fun onChangedListener(dRef: DatabaseReference) {
         dRef.addValueEventListener(object : ValueEventListener {
             @SuppressLint("SetTextI18n")
             override fun onDataChange(snapshot: DataSnapshot) {
                 binding.apply {
                     hpText.setText(snapshot.value.toString() + " HP")
                     hp = snapshot.value.toString().toInt()


                 }

             }

             override fun onCancelled(error: DatabaseError) {

             }

         })
     }
    private fun onChangedListenerMoney(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    goldText.setText(snapshot.value.toString())
                    money = snapshot.value.toString().toInt()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerMaxHp(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    hpMax = snapshot.value.toString().toInt()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerLvlThis(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    levelText.setText(snapshot.value.toString())
                    lvlThis = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerKillMobs(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    killsmobText.setText(snapshot.value.toString() + "/10")
                    killMobs = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerDamage(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    dmgText.setText(snapshot.value.toString())
                    damage = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerUseBomb(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    useBomb = snapshot.value.toString().toInt()

                    if (useBomb == 1) {
                        removeWorld = 2
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceItemOne(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_item_1 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceItemTwo(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_item_2 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceItemThree(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_item_3 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceItemFo(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_item_4 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceItemFive(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_item_5 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun onChangedListenerPriceManOne(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_man_1 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceManTwo(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_man_2 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
    private fun onChangedListenerPriceManThree(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    price_man_3 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun onChangedListenerDamageManOne(dRef: DatabaseReference) {
        dRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    //  dmgText.setText(snapshot.value.toString())

                    damage_mans_1 = snapshot.value.toString().toInt()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }



}

