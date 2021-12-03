package com.sepiagraphic.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sepiagraphic.R
import com.sepiagraphic.Services.DataService
import com.sepiagraphic.adapters.AboutSliderAdapter
import com.sepiagraphic.databinding.FragmentAboutUsBinding


class AboutUsFragment : Fragment() {




    lateinit var categoriesAdapter : AboutSliderAdapter


    private var _binding: FragmentAboutUsBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fun TextView.setHtmlText(source:String){
            this.text = HtmlCompat.fromHtml(source,HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
        binding.aboutUsText.setHtmlText(getString(R.string.AboutInfo))

        // Slider
        categoriesAdapter = AboutSliderAdapter(this.requireActivity(),DataService.whyUs)
        binding.viewPagerAbout.adapter = categoriesAdapter

        binding.viewPagerAbout.orientation = ViewPager2.ORIENTATION_HORIZONTAL //in case of you want to change the orientation
        TabLayoutMediator(binding.tabLayout, binding.viewPagerAbout) { tab, position ->
        }.attach()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}