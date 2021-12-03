package com.sepiagraphic.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sepiagraphic.R
import com.sepiagraphic.databinding.FragmentHomeBinding
import com.sepiagraphic.ui.contact.ContactUsActivity
import com.sepiagraphic.ui.services.PolycarbonateActivity

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // home buttons Navigation
        binding.aboutButton1.setOnClickListener {
            findNavController().navigate(R.id.navigation_AboutUs)
        }
        binding.aboutButton2.setOnClickListener {
            findNavController().navigate(R.id.navigation_AboutUs)
        }
        binding.chapDigital.setOnClickListener {
            findNavController().navigate(R.id.navigation_services)
        }
        binding.orderButton1.setOnClickListener {
            findNavController().navigate(R.id.navigation_order)
        }
        binding.orderButton2.setOnClickListener {
            findNavController().navigate(R.id.navigation_order)
        }
        binding.polycarbonite.setOnClickListener {
            val intent = Intent(this.requireActivity(),PolycarbonateActivity::class.java)
            startActivity(intent)
        }
        binding.cotactButton1.setOnClickListener {
            val intent = Intent(this.requireActivity(),ContactUsActivity::class.java)
            startActivity(intent)
        }
        binding.contactButton2.setOnClickListener {
            val intent = Intent(this.requireActivity(),ContactUsActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}