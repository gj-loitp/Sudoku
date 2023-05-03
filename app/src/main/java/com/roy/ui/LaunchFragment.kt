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

        }
        binding.btMore.setOnClickListener {

        }
        binding.btShare.setOnClickListener {

        }
        binding.btPolicy.setOnClickListener {

        }
    }
}
