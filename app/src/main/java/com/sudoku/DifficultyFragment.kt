package com.sudoku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.roy.itf.Communicator
import com.sudoku.databinding.FDifficultyBinding

class DifficultyFragment : Fragment() {
    private lateinit var binding: FDifficultyBinding
    lateinit var comm: Communicator


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FDifficultyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comm = activity as Communicator

        binding.btEasy.setOnClickListener {
            comm.passDataCom("easy")
            view.findNavController().navigate(R.id.action_difficultyFragment_to_playScreen)
        }
        binding.btMedium.setOnClickListener {
            comm.passDataCom("medium")
            view.findNavController().navigate(R.id.action_difficultyFragment_to_playScreen)
        }
        binding.btHard.setOnClickListener {
            comm.passDataCom("hard")
            view.findNavController().navigate(R.id.action_difficultyFragment_to_playScreen)
        }
    }
}
