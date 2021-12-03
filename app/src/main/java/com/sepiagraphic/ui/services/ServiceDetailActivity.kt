package com.sepiagraphic.ui.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepiagraphic.R
import com.sepiagraphic.Services.DataService
import com.sepiagraphic.adapters.ServiceDetailRecyclerAdapter
import com.sepiagraphic.databinding.ActivityServiceDetailBinding
import kotlinx.android.synthetic.main.toolbar_style.*

class ServiceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceDetailBinding
    lateinit var categoriesAdapter: ServiceDetailRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar Configuration
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_style)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        back_button.setOnClickListener { finish() }
        TextToolbar.text = "خدمات چاپ دیجیتال"


        //Adapter
        categoriesAdapter = ServiceDetailRecyclerAdapter(this, DataService.services) { category ->
            serviceInfo(category.title)
        }
        binding.serviceDetailRecyclerView.adapter = categoriesAdapter

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        binding.serviceDetailRecyclerView.layoutManager = layoutManager
        binding.serviceDetailRecyclerView.setHasFixedSize(true)

        //Get Extra
        val categoryTitle = intent.getStringExtra("categoryTitle")
        if (categoryTitle != null) {
            serviceInfo(categoryTitle)
        }
    }

    fun TextView.setHtmlText(source: String) {
        this.text = HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun serviceInfo(categoryTitle: String) {
        when (categoryTitle) {
            "چاپ استیکر" -> {
                binding.serviceDetailTitle.text = "چاپ استیکر"
                binding.serviceDetailSubTitle.text ="لیبل پی وی سی ضد آب"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_sticker)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.sticker))
            }
            "لیبل ژله ای" -> {
                binding.serviceDetailTitle.text = "لیبل ژله ای"
                binding.serviceDetailSubTitle.text ="لیبل کریستالی برجسته"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_jelly)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.jelly))
            }
            "لیبل کاغذی" -> {
                binding.serviceDetailTitle.text = "لیبل کاغذی"
                binding.serviceDetailSubTitle.text ="لیبل پشت چسبدار کاغذی"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_paper)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.paper))
            }
            "لیبل متالایز" -> {
                binding.serviceDetailTitle.text = "لیبل متالایز"
                binding.serviceDetailSubTitle.text ="لیبل پی وی سی نقره ای رنگ"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_metalizer)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.metalizer))
            }
            "چاپ پوستر" -> {
                binding.serviceDetailTitle.text = "چاپ پوستر"
                binding.serviceDetailSubTitle.text ="پی وی سی یا کاغذ بدون چسب"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_poster)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.poster))
            }
            "برچسب اموال" -> {
                binding.serviceDetailTitle.text = "برچسب اموال"
                binding.serviceDetailSubTitle.text ="لیبل شمارش و کنترل اموال"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_property)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.property))
            }
            "چاپ بوم" -> {
                binding.serviceDetailTitle.text = "چاپ بوم"
                binding.serviceDetailSubTitle.text ="چاپ روی پارچه پلی استر یا الیاف طبیعی"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_bom)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.bom))
            }
            "لیبل شبرنگ" -> {
                binding.serviceDetailTitle.text = "لیبل شبرنگ"
                binding.serviceDetailSubTitle.text = "لیبل با قابلیت رفلکس نور"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_shabrang)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.shabrang))
            }
            "چاپ کاتری" -> {
                binding.serviceDetailTitle.text = "چاپ کاتری"
                binding.serviceDetailSubTitle.text ="چاپ، برش و پرس حرارتی"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_kateri)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.kateri))
            }
            "برچسب مش" -> {
                binding.serviceDetailTitle.text = "برچسب مش"
                binding.serviceDetailSubTitle.text ="برچسب متخلخل با دید یک طرفه"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_mesh)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.mesh))
            }
            "پوستر دیواری" -> {
                binding.serviceDetailTitle.text = "پوستر دیواری"
                binding.serviceDetailSubTitle.text ="چاپ طرح دلخواه بر روی کاغذ دیواری"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_wallposter)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.wallposter))
            }
            "برش کاترپلاتر" -> {
                binding.serviceDetailTitle.text = "برش کاترپلاتر"
                binding.serviceDetailSubTitle.text ="برش استیکر و دوربری چاپ"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_caterplater)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.caterplater))
            }
            "استیکر شفاف و مات کن" -> {
                binding.serviceDetailTitle.text = "استیکر شفاف و مات کن"
                binding.serviceDetailSubTitle.text ="لیبل پی وی سی بی رنگ"
                binding.serviceDetailImage.setImageResource(R.drawable.ic_shafaf)
                binding.serviceDetailInfo.setHtmlText(getString(R.string.shafaf))

            }
        }
    }
}
