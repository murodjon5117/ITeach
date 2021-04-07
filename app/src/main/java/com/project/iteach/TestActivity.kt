package com.project.iteach

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginEnd
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val k="alijon valijon, ganijon dnfd asjhdhsja sjbdcjs dsjbdjs dsjbdjs ibdajbd iabdaj aidiadb aidbaid aidbbia"
        val words = k.split("\\W+".toRegex())

        Log.i("words", words.toString())

        for (i in words.indices) {
            val text = TextView(this)

            text.layoutParams = ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
            text.setBackgroundColor(R.drawable.btn_blue_normal)

            text.text = "" + words[i]
            llMain.addView(text)
        }

    }
}