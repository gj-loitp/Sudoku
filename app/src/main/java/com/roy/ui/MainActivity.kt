package com.roy.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.applovin.mediation.ads.MaxAdView
import com.roy.R
import com.roy.databinding.AMainBinding
import com.roy.ext.createAdBanner
import com.roy.itf.Communicator

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: AMainBinding
    private var adView: MaxAdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adView = this@MainActivity.createAdBanner(
            logTag = MainActivity::class.java.simpleName,
            bkgColor = Color.TRANSPARENT,
            viewGroup = binding.flAd,
            isAdaptiveBanner = true,
        )
    }

    override fun onDestroy() {
        adView?.destroy()
        super.onDestroy()
    }

    override fun passDataCom(input: String) {
        val bundle = Bundle()
        bundle.putString("difficulty_text", input)
        val transaction = this.supportFragmentManager.beginTransaction()
        val playFrag = PlayScreenFragment()
        playFrag.arguments = bundle
        transaction.replace(R.id.mainActivityId, playFrag)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}
