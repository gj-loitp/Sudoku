package com.roy.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxInterstitialAd
import com.roy.BuildConfig
import com.roy.R
import com.roy.databinding.FLaunchScreenBinding
import com.roy.ext.i
import com.roy.ext.moreApp
import com.roy.ext.openBrowserPolicy
import com.roy.ext.rateApp
import com.roy.ext.shareApp
import java.util.concurrent.TimeUnit
import kotlin.math.min
import kotlin.math.pow

class LaunchFragment : Fragment() {
    private lateinit var binding: FLaunchScreenBinding
    private var interstitialAd: MaxInterstitialAd? = null
    private var retryAttempt = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FLaunchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createAdInter()

        binding.tvVersion.text = "Version ${BuildConfig.VERSION_NAME}"
        binding.btPlay.setOnClickListener {
            showAd {
                view.findNavController().navigate(R.id.action_launchScreen_to_difficultyFragment)
            }
        }
        binding.btAbout.setOnClickListener {
            view.findNavController().navigate(R.id.action_launchScreen_to_aboutFragment)
        }
        binding.btSolver.setOnClickListener {
            showAd {
                view.findNavController().navigate(R.id.action_launchScreen_to_solverFragment)
            }
        }
        binding.btRate.setOnClickListener {
            activity?.let {
                it.rateApp(it.packageName)
            }
        }
        binding.btMore.setOnClickListener {
            activity?.moreApp()
        }
        binding.btShare.setOnClickListener {
            activity?.shareApp()
        }
        binding.btPolicy.setOnClickListener {
            activity?.openBrowserPolicy()
        }
    }

    private fun createAdInter() {
        val enableAdInter = getString(R.string.EnableAdInter) == "true"
        if (enableAdInter) {
            interstitialAd = MaxInterstitialAd(getString(R.string.INTER), activity)
            interstitialAd?.let { ad ->
                ad.setListener(object : MaxAdListener {
                    override fun onAdLoaded(p0: MaxAd?) {
                        logI("onAdLoaded")
                        retryAttempt = 0
                    }

                    override fun onAdDisplayed(p0: MaxAd?) {
                        logI("onAdDisplayed")
                    }

                    override fun onAdHidden(p0: MaxAd?) {
                        logI("onAdHidden")
                        // Interstitial Ad is hidden. Pre-load the next ad
                        interstitialAd?.loadAd()
                    }

                    override fun onAdClicked(p0: MaxAd?) {
                        logI("onAdClicked")
                    }

                    override fun onAdLoadFailed(p0: String?, p1: MaxError?) {
                        logI("onAdLoadFailed")
                        retryAttempt++
                        val delayMillis =
                            TimeUnit.SECONDS.toMillis(2.0.pow(min(6, retryAttempt)).toLong())

                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                interstitialAd?.loadAd()
                            }, delayMillis
                        )
                    }

                    override fun onAdDisplayFailed(p0: MaxAd?, p1: MaxError?) {
                        logI("onAdDisplayFailed")
                        // Interstitial ad failed to display. We recommend loading the next ad.
                        interstitialAd?.loadAd()
                    }

                })
                ad.setRevenueListener {
                    logI("onAdDisplayed")
                }

                // Load the first ad.
                ad.loadAd()
            }
        }
    }

    private fun showAd(runnable: Runnable? = null) {
        val enableAdInter = getString(R.string.EnableAdInter) == "true"
        if (enableAdInter) {
            if (interstitialAd == null) {
                runnable?.run()
            } else {
                interstitialAd?.let { ad ->
                    if (ad.isReady) {
                        ad.showAd()
                        runnable?.run()
                    } else {
                        runnable?.run()
                    }
                }
            }
        } else {
            runnable?.run()
        }
    }

    fun logI(msg: String) {
        i(javaClass.simpleName, msg)
    }
}
