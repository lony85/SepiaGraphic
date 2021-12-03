package com.sepiagraphic.ui.services

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sepiagraphic.Services.DataService
import com.sepiagraphic.adapters.ServicesRecyclerAdapter
import com.sepiagraphic.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {


    private var _binding: FragmentServicesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var categoriesAdapter:ServicesRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        categoriesAdapter = ServicesRecyclerAdapter(this.requireActivity(),DataService.services){
            category -> val serviceDetail = Intent(this.requireActivity(),ServiceDetailActivity::class.java)
            serviceDetail.putExtra("categoryTitle",category.title)
            startActivity(serviceDetail)
        }
        binding.servicesRecyclerView.adapter = categoriesAdapter

        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.servicesRecyclerView.layoutManager = layoutManager
        binding.servicesRecyclerView.setHasFixedSize(true)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}