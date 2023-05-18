package com.himawan.pembelajarantunanetra

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.himawan.pembelajarantunanetra.adapter.ImageSliderAdapter
import com.himawan.pembelajarantunanetra.databinding.ActivityOrgansBinding
import com.himawan.pembelajarantunanetra.model.ImageData

class OrgansActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityOrgansBinding

    //slideradapter and stuff
    private lateinit var adapter: ImageSliderAdapter
    private var list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrgansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TEsSlider
        firstSlideList()
        //TEsSlider

        var i: Int = 0
        binding.btnNext.setOnClickListener {
            i++
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
        }

        binding.btnBack.setOnClickListener {
            i--
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
        }

    }

    private fun firstSlideList() {
        list.add(
            ImageData(
                R.drawable.cat_image
            )
        )
        list.add(
            ImageData(
                R.drawable.image_cow
            )
        )
        list.add(
            ImageData(
                R.drawable.horse_image
            )
        )
        adapter = ImageSliderAdapter(list)
        binding.sliderOrgan.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.sliderOrgan.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)

            }
        })
    }

    private fun setIndicator() {
        for (i in 0 until list.size) {
            dots.add(TextView(this))
            dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            dots[i].textSize = 14f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    private fun selectedDot(position: Int) {
        for (i in 0 until list.size) {
            if (i == position) {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.primary_variant_1))
            } else {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.gray_dot))
            }
        }
    }
}
