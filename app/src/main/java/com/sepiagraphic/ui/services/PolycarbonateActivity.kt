package com.sepiagraphic.ui.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.text.HtmlCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sepiagraphic.R
import com.sepiagraphic.Services.DataService
import com.sepiagraphic.adapters.PolycarbonateSliderAdapter
import com.sepiagraphic.databinding.ActivityPolycarbonateBinding
import kotlinx.android.synthetic.main.toolbar_style.*

class PolycarbonateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPolycarbonateBinding
    lateinit var categoriesAdapter : PolycarbonateSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPolycarbonateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar Configuration
        val toolbar = findViewById<Toolbar>(R.id.toolbar_style)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        back_button.setOnClickListener { finish() }
        TextToolbar.text = "پنل پلی کربنات"

        //Detailed Text
        fun TextView.setHtmlText(source:String){
            this.text = HtmlCompat.fromHtml(source,HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
        binding.polycarbonateText.setHtmlText(getString(R.string.polycarbonate_info))

        // Slider
        categoriesAdapter = PolycarbonateSliderAdapter(this, DataService.polycarbonate)
        binding.viewPagerPolycarbonate.adapter = categoriesAdapter


        binding.viewPagerPolycarbonate.orientation = ViewPager2.ORIENTATION_HORIZONTAL //in case of you want to change the orientation
        TabLayoutMediator(binding.tabLayoutPolycarbonate, binding.viewPagerPolycarbonate) { tab, position ->
        }.attach()

    }
}