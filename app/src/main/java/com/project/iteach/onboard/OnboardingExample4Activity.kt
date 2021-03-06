package com.project.iteach.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.project.iteach.R
import com.project.iteach.login.RegisterActivity

import kotlinx.android.synthetic.main.activity_onboarding_example4.*

class OnboardingExample4Activity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private lateinit var btnBack: Button
    private lateinit var btnNext: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_example4)
        mViewPager = viewPager
        mViewPager.adapter = OnboardingViewPagerAdapter4(supportFragmentManager, this)
        mViewPager.offscreenPageLimit = 1
        btnBack = btn_previous_step
        btnNext = btn_next_step
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                if(position == 2){
                    btnNext.text = getText(R.string.finish)
                }else{
                    btnNext.text = getText(R.string.next)
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })

        btnNext.setOnClickListener {
            if (getItem(+1) > mViewPager.childCount-1) {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                mViewPager.setCurrentItem(getItem(+1), true)
            }
        }

            btnBack.setOnClickListener {
            if (getItem(+1) == 1) {
                finish()
            } else {
                mViewPager.setCurrentItem(getItem(-1), true)
            }
        }
    }

    private fun getItem(i: Int): Int {
        return mViewPager.currentItem + i
    }
}
