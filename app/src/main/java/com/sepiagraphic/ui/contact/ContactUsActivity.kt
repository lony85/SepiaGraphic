package com.sepiagraphic.ui.contact

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sepiagraphic.R
import com.sepiagraphic.databinding.ActivityContactBinding
import kotlinx.android.synthetic.main.toolbar_style.TextToolbar
import kotlinx.android.synthetic.main.toolbar_style.back_button
import kotlinx.android.synthetic.main.toolbar_style_contact.*

class ContactUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sepiaGraphic = LatLng(35.69027, 51.420444)
        googleMap.addMarker(
            MarkerOptions()
                .position(sepiaGraphic)
                .title("سپیا گرافیک")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_gps_marker))
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sepiaGraphic, 15f))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar Configuration
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_style)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        back_button.setOnClickListener { finish() }
        TextToolbar.text = "تماس با ما"
        call.setOnClickListener {
            val call_intent = Intent(Intent.ACTION_DIAL)
            call_intent.data = Uri.parse("tel:<02133942624>")
            startActivity(call_intent)
        }

        //Address
        binding.addressText.setHtmlText(getString(R.string.addressInfo))
        //tel Numbers
        binding.telNo1.text = FaNum.convert("021 33942624")
        binding.telNo2.text = FaNum.convert("021 33942625")
        binding.telNo3.text = FaNum.convert("0912 4969676")
        binding.telNo4.text = FaNum.convert("0912 3195804")
        //website
        val webUri = Uri.parse("https://sepiagraphic.com/")
        val iWeb = Intent(Intent.ACTION_VIEW, webUri)
        binding.websiteAddress.setOnClickListener {
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://sepiagraphic.com/")
                    )
                )
            }
        }

        // googleMap
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    fun TextView.setHtmlText(source: String) {
        this.text = HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
    object FaNum {
        fun convert(faNumbers: String): String {
            var faNumbers = faNumbers
            val mChars = arrayOf(
                arrayOf("0", "۰"),
                arrayOf("1", "۱"),
                arrayOf("2", "۲"),
                arrayOf("3", "۳"),
                arrayOf("4", "۴"),
                arrayOf("5", "۵"),
                arrayOf("6", "۶"),
                arrayOf("7", "۷"),
                arrayOf("8", "۸"),
                arrayOf("9", "۹")
            )
            for (num in mChars) {
                faNumbers = faNumbers.replace(num[0], num[1])
            }
            return faNumbers
        }
    }
}