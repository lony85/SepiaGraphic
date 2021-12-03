package com.sepiagraphic.ui.order

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.sepiagraphic.R
import com.sepiagraphic.databinding.FragmentOrderBinding
import java.lang.Exception

class OrderFragment : Fragment() {


    private var _binding: FragmentOrderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fun TextView.setHtmlText(source:String){
            this.text = HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
        binding.orderText.setHtmlText(getString(R.string.OrderInfo))

        binding.orderWhatsapp.setOnClickListener {
            Toast.makeText(requireActivity(),"در حال انتقال به پیام رسان",Toast.LENGTH_SHORT).show()
            try{
            val url = "https://api.whatsapp.com/send?phone="+ "+98 903 5697373"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)}
            catch (e:Exception)
            {
                //catch Error
            }
        }

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}