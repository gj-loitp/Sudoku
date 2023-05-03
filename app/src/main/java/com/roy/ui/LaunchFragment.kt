package com.roy.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.roy.BuildConfig
import com.roy.R
import com.roy.databinding.FLaunchScreenBinding
import com.roy.ext.moreApp
import com.roy.ext.openBrowserPolicy
import com.roy.ext.rateApp
import com.roy.ext.shareApp

class LaunchFragment : Fragment() {
    private lateinit var binding: FLaunchScreenBinding

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

        binding.tvVersion.text = "Version ${BuildConfig.VERSION_NAME}"
        binding.btPlay.setOnClickListener {
            view.findNavController().navigate(R.id.action_launchScreen_to_difficultyFragment)
        }
        binding.btAbout.setOnClickListener {
            view.findNavController().navigate(R.id.action_launchScreen_to_aboutFragment)
        }
        binding.btSolver.setOnClickListener {
            view.findNavController().navigate(R.id.action_launchScreen_to_solverFragment)
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
}
