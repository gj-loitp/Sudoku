package com.sudoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.roy.itf.Communicator

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

    }

    override fun passDataCom(input: String) {
        val bundle = Bundle()
        bundle.putString("difficulty_text",input)

        val transaction = this.supportFragmentManager.beginTransaction()
        val playFrag = PlayScreen()
        playFrag.arguments = bundle

        transaction.replace(R.id.mainActivityId, playFrag)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}