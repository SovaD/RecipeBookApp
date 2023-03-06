package com.sova.recipeapp


import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import android.widget.ImageView
import android.widget.TextView
import com.sova.recipeapp.ui.base.BaseActivity
import com.sova.recipeapp.ui.main.MainActivity


class SplashScreenActivity : BaseActivity() {
    private lateinit var bottomtotop: Animation
    private lateinit var smtobig: Animation

    private lateinit var iv_food:ImageView;
    private lateinit var tv_title:TextView;

    override fun getLayoutId(): Int = R.layout.activity_splash_screen

    override fun onActivityReady(savedInstanceState: Bundle?) {
        bottomtotop = AnimationUtils.loadAnimation(this, R.anim.bottomtotop)
        smtobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig)

        iv_food = findViewById(R.id.iv_food);
        tv_title = findViewById(R.id.tv_title);


        iv_food.startAnimation(smtobig)
        tv_title.startAnimation(bottomtotop)
        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                } finally {
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
        thread.start()
    }



}