package com.sudoku

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_play_screen.*
import org.jetbrains.anko.find
import java.util.*
import kotlin.collections.HashMap

class PlayScreen : Fragment(), View.OnClickListener {
    private var selectedButton: Button? = null
    private var userInputBoard = Array(9) {IntArray(9) {0} }
    private var matrix = Array(9) {IntArray(9) {0} }
    private var buttonMap = HashMap<String, Button>()
    private var reverseMap = HashMap<Button, String>()
    private var timerVal:CountDownTimer? = null
    private var initialSolveTime = 900000L
    private lateinit var difficultyLevel:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_play_screen, container, false)

        Log.i("Solver","in play fragment")

        difficultyLevel = arguments?.getString("difficulty_text").toString()
        initialSolveTime  = 900000L
        if (difficultyLevel == "easy") initialSolveTime = 900000L
        else if (difficultyLevel == "medium") initialSolveTime = 600000L
        else  initialSolveTime = 300000L

        timerVal = object : CountDownTimer(initialSolveTime, 1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                initialSolveTime = p0
                var displayTimerText:String?
                val minutes = (p0 / 1000 / 60).toInt()
                displayTimerText = if (minutes / 10 == 0) "0$minutes:"
                else "$minutes:"

                val seconds = (p0 / 1000).toInt() % 60
                displayTimerText += if (seconds / 10 == 0) "0$seconds"
                else "$seconds"

                timer.text = displayTimerText
            }

            override fun onFinish() {
                // Time is up
            }

        }
        (timerVal as CountDownTimer).start()

        val b11: Button = view.findViewById(R.id.b11)
        val b12: Button = view.findViewById(R.id.b12)
        val b13: Button = view.findViewById(R.id.b13)
        val b14: Button = view.findViewById(R.id.b14)
        val b15: Button = view.findViewById(R.id.b15)
        val b16: Button = view.findViewById(R.id.b16)
        val b17: Button = view.findViewById(R.id.b17)
        val b18: Button = view.findViewById(R.id.b18)
        val b19: Button = view.findViewById(R.id.b19)
        val b21: Button = view.findViewById(R.id.b21)
        val b22: Button = view.findViewById(R.id.b22)
        val b23: Button = view.findViewById(R.id.b23)
        val b24: Button = view.findViewById(R.id.b24)
        val b25: Button = view.findViewById(R.id.b25)
        val b26: Button = view.findViewById(R.id.b26)
        val b27: Button = view.findViewById(R.id.b27)
        val b28: Button = view.findViewById(R.id.b28)
        val b29: Button = view.findViewById(R.id.b29)
        val b31: Button = view.findViewById(R.id.b31)
        val b32: Button = view.findViewById(R.id.b32)
        val b33: Button = view.findViewById(R.id.b33)
        val b34: Button = view.findViewById(R.id.b34)
        val b35: Button = view.findViewById(R.id.b35)
        val b36: Button = view.findViewById(R.id.b36)
        val b37: Button = view.findViewById(R.id.b37)
        val b38: Button = view.findViewById(R.id.b38)
        val b39: Button = view.findViewById(R.id.b39)
        val b41: Button = view.findViewById(R.id.b41)
        val b42: Button = view.findViewById(R.id.b42)
        val b43: Button = view.findViewById(R.id.b43)
        val b44: Button = view.findViewById(R.id.b44)
        val b45: Button = view.findViewById(R.id.b45)
        val b46: Button = view.findViewById(R.id.b46)
        val b47: Button = view.findViewById(R.id.b47)
        val b48: Button = view.findViewById(R.id.b48)
        val b49: Button = view.findViewById(R.id.b49)
        val b51: Button = view.findViewById(R.id.b51)
        val b52: Button = view.findViewById(R.id.b52)
        val b53: Button = view.findViewById(R.id.b53)
        val b54: Button = view.findViewById(R.id.b54)
        val b55: Button = view.findViewById(R.id.b55)
        val b56: Button = view.findViewById(R.id.b56)
        val b57: Button = view.findViewById(R.id.b57)
        val b58: Button = view.findViewById(R.id.b58)
        val b59: Button = view.findViewById(R.id.b59)
        val b61: Button = view.findViewById(R.id.b61)
        val b62: Button = view.findViewById(R.id.b62)
        val b63: Button = view.findViewById(R.id.b63)
        val b64: Button = view.findViewById(R.id.b64)
        val b65: Button = view.findViewById(R.id.b65)
        val b66: Button = view.findViewById(R.id.b66)
        val b67: Button = view.findViewById(R.id.b67)
        val b68: Button = view.findViewById(R.id.b68)
        val b69: Button = view.findViewById(R.id.b69)
        val b71: Button = view.findViewById(R.id.b71)
        val b72: Button = view.findViewById(R.id.b72)
        val b73: Button = view.findViewById(R.id.b73)
        val b74: Button = view.findViewById(R.id.b74)
        val b75: Button = view.findViewById(R.id.b75)
        val b76: Button = view.findViewById(R.id.b76)
        val b77: Button = view.findViewById(R.id.b77)
        val b78: Button = view.findViewById(R.id.b78)
        val b79: Button = view.findViewById(R.id.b79)
        val b81: Button = view.findViewById(R.id.b81)
        val b82: Button = view.findViewById(R.id.b82)
        val b83: Button = view.findViewById(R.id.b83)
        val b84: Button = view.findViewById(R.id.b84)
        val b85: Button = view.findViewById(R.id.b85)
        val b86: Button = view.findViewById(R.id.b86)
        val b87: Button = view.findViewById(R.id.b87)
        val b88: Button = view.findViewById(R.id.b88)
        val b89: Button = view.findViewById(R.id.b89)
        val b91: Button = view.findViewById(R.id.b91)
        val b92: Button = view.findViewById(R.id.b92)
        val b93: Button = view.findViewById(R.id.b93)
        val b94: Button = view.findViewById(R.id.b94)
        val b95: Button = view.findViewById(R.id.b95)
        val b96: Button = view.findViewById(R.id.b96)
        val b97: Button = view.findViewById(R.id.b97)
        val b98: Button = view.findViewById(R.id.b98)
        val b99: Button = view.findViewById(R.id.b99)

        buttonMap["b11"] = b11
        buttonMap["b12"] = b12
        buttonMap["b13"] = b13
        buttonMap["b14"] = b14
        buttonMap["b15"] = b15
        buttonMap["b16"] = b16
        buttonMap["b17"] = b17
        buttonMap["b18"] = b18
        buttonMap["b19"] = b19
        buttonMap["b21"] = b21
        buttonMap["b22"] = b22
        buttonMap["b23"] = b23
        buttonMap["b24"] = b24
        buttonMap["b25"] = b25
        buttonMap["b26"] = b26
        buttonMap["b27"] = b27
        buttonMap["b28"] = b28
        buttonMap["b29"] = b29
        buttonMap["b31"] = b31
        buttonMap["b32"] = b32
        buttonMap["b33"] = b33
        buttonMap["b34"] = b34
        buttonMap["b35"] = b35
        buttonMap["b36"] = b36
        buttonMap["b37"] = b37
        buttonMap["b38"] = b38
        buttonMap["b39"] = b39
        buttonMap["b41"] = b41
        buttonMap["b42"] = b42
        buttonMap["b43"] = b43
        buttonMap["b44"] = b44
        buttonMap["b45"] = b45
        buttonMap["b46"] = b46
        buttonMap["b47"] = b47
        buttonMap["b48"] = b48
        buttonMap["b49"] = b49
        buttonMap["b51"] = b51
        buttonMap["b52"] = b52
        buttonMap["b53"] = b53
        buttonMap["b54"] = b54
        buttonMap["b55"] = b55
        buttonMap["b56"] = b56
        buttonMap["b57"] = b57
        buttonMap["b58"] = b58
        buttonMap["b59"] = b59
        buttonMap["b61"] = b61
        buttonMap["b62"] = b62
        buttonMap["b63"] = b63
        buttonMap["b64"] = b64
        buttonMap["b65"] = b65
        buttonMap["b66"] = b66
        buttonMap["b67"] = b67
        buttonMap["b68"] = b68
        buttonMap["b69"] = b69
        buttonMap["b71"] = b71
        buttonMap["b72"] = b72
        buttonMap["b73"] = b73
        buttonMap["b74"] = b74
        buttonMap["b75"] = b75
        buttonMap["b76"] = b76
        buttonMap["b77"] = b77
        buttonMap["b78"] = b78
        buttonMap["b79"] = b79
        buttonMap["b81"] = b81
        buttonMap["b82"] = b82
        buttonMap["b83"] = b83
        buttonMap["b84"] = b84
        buttonMap["b85"] = b85
        buttonMap["b86"] = b86
        buttonMap["b87"] = b87
        buttonMap["b88"] = b88
        buttonMap["b89"] = b89
        buttonMap["b91"] = b91
        buttonMap["b92"] = b92
        buttonMap["b93"] = b93
        buttonMap["b94"] = b94
        buttonMap["b95"] = b95
        buttonMap["b96"] = b96
        buttonMap["b97"] = b97
        buttonMap["b98"] = b98
        buttonMap["b99"] = b99

        reverseMap[b11]="b11"
        reverseMap[b12]="b12"
        reverseMap[b13]="b13"
        reverseMap[b14]="b14"
        reverseMap[b15]="b15"
        reverseMap[b16]="b16"
        reverseMap[b17]="b17"
        reverseMap[b18]="b18"
        reverseMap[b19]="b19"
        reverseMap[b21]="b21"
        reverseMap[b22]="b22"
        reverseMap[b23]="b23"
        reverseMap[b24]="b24"
        reverseMap[b25]="b25"
        reverseMap[b26]="b26"
        reverseMap[b27]="b27"
        reverseMap[b28]="b28"
        reverseMap[b29]="b29"
        reverseMap[b31]="b31"
        reverseMap[b32]="b32"
        reverseMap[b33]="b33"
        reverseMap[b34]="b34"
        reverseMap[b35]="b35"
        reverseMap[b36]="b36"
        reverseMap[b37]="b37"
        reverseMap[b38]="b38"
        reverseMap[b39]="b39"
        reverseMap[b41]="b41"
        reverseMap[b42]="b42"
        reverseMap[b43]="b43"
        reverseMap[b44]="b44"
        reverseMap[b45]="b45"
        reverseMap[b46]="b46"
        reverseMap[b47]="b47"
        reverseMap[b48]="b48"
        reverseMap[b49]="b49"
        reverseMap[b51]="b51"
        reverseMap[b52]="b52"
        reverseMap[b53]="b53"
        reverseMap[b54]="b54"
        reverseMap[b55]="b55"
        reverseMap[b56]="b56"
        reverseMap[b57]="b57"
        reverseMap[b58]="b58"
        reverseMap[b59]="b59"
        reverseMap[b61]="b61"
        reverseMap[b62]="b62"
        reverseMap[b63]="b63"
        reverseMap[b64]="b64"
        reverseMap[b65]="b65"
        reverseMap[b66]="b66"
        reverseMap[b67]="b67"
        reverseMap[b68]="b68"
        reverseMap[b69]="b69"
        reverseMap[b71]="b71"
        reverseMap[b72]="b72"
        reverseMap[b73]="b73"
        reverseMap[b74]="b74"
        reverseMap[b75]="b75"
        reverseMap[b76]="b76"
        reverseMap[b77]="b77"
        reverseMap[b78]="b78"
        reverseMap[b79]="b79"
        reverseMap[b81]="b81"
        reverseMap[b82]="b82"
        reverseMap[b83]="b83"
        reverseMap[b84]="b84"
        reverseMap[b85]="b85"
        reverseMap[b86]="b86"
        reverseMap[b87]="b87"
        reverseMap[b88]="b88"
        reverseMap[b89]="b89"
        reverseMap[b91]="b91"
        reverseMap[b92]="b92"
        reverseMap[b93]="b93"
        reverseMap[b94]="b94"
        reverseMap[b95]="b95"
        reverseMap[b96]="b96"
        reverseMap[b97]="b97"
        reverseMap[b98]="b98"
        reverseMap[b99]="b99"

        generatematrix()
        if(b11.isClickable)
        b11.setOnClickListener(this)
        if(b12.isClickable)
        b12.setOnClickListener(this)
        if(b13.isClickable)
        b13.setOnClickListener(this)
        if(b14.isClickable)
        b14.setOnClickListener(this)
        if(b15.isClickable)
        b15.setOnClickListener(this)
        if(b16.isClickable)
        b16.setOnClickListener(this)
        if(b17.isClickable)
        b17.setOnClickListener(this)
        if(b18.isClickable)
        b18.setOnClickListener(this)
        if(b19.isClickable)
        b19.setOnClickListener(this)
        if(b21.isClickable)
        b21.setOnClickListener(this)
        if(b22.isClickable)
        b22.setOnClickListener(this)
        if(b23.isClickable)
        b23.setOnClickListener(this)
        if(b24.isClickable)
        b24.setOnClickListener(this)
        if(b25.isClickable)
        b25.setOnClickListener(this)
        if(b26.isClickable)
        b26.setOnClickListener(this)
        if(b27.isClickable)
        b27.setOnClickListener(this)
        if(b28.isClickable)
        b28.setOnClickListener(this)
        if(b29.isClickable)
        b29.setOnClickListener(this)
        if(b31.isClickable)
        b31.setOnClickListener(this)
        if(b32.isClickable)
        b32.setOnClickListener(this)
        if(b33.isClickable)
        b33.setOnClickListener(this)
        if(b34.isClickable)
        b34.setOnClickListener(this)
        if(b35.isClickable)
        b35.setOnClickListener(this)
        if(b36.isClickable)
        b36.setOnClickListener(this)
        if(b37.isClickable)
        b37.setOnClickListener(this)
        if(b38.isClickable)
        b38.setOnClickListener(this)
        if(b39.isClickable)
        b39.setOnClickListener(this)
        if(b41.isClickable)
        b41.setOnClickListener(this)
        if(b42.isClickable)
        b42.setOnClickListener(this)
        if(b43.isClickable)
        b43.setOnClickListener(this)
        if(b44.isClickable)
        b44.setOnClickListener(this)
        if(b45.isClickable)
        b45.setOnClickListener(this)
        if(b46.isClickable)
        b46.setOnClickListener(this)
        if(b47.isClickable)
        b47.setOnClickListener(this)
        if(b48.isClickable)
        b48.setOnClickListener(this)
        if(b49.isClickable)
        b49.setOnClickListener(this)
        if(b51.isClickable)
        b51.setOnClickListener(this)
        if(b52.isClickable)
        b52.setOnClickListener(this)
        if(b53.isClickable)
        b53.setOnClickListener(this)
        if(b54.isClickable)
        b54.setOnClickListener(this)
        if(b55.isClickable)
        b55.setOnClickListener(this)
        if(b56.isClickable)
        b56.setOnClickListener(this)
        if(b57.isClickable)
        b57.setOnClickListener(this)
        if(b58.isClickable)
        b58.setOnClickListener(this)
        if(b59.isClickable)
        b59.setOnClickListener(this)
        if(b61.isClickable)
        b61.setOnClickListener(this)
        if(b62.isClickable)
        b62.setOnClickListener(this)
        if(b63.isClickable)
        b63.setOnClickListener(this)
        if(b64.isClickable)
        b64.setOnClickListener(this)
        if(b65.isClickable)
        b65.setOnClickListener(this)
        if(b66.isClickable)
        b66.setOnClickListener(this)
        if(b67.isClickable)
        b67.setOnClickListener(this)
        if(b68.isClickable)
        b68.setOnClickListener(this)
        if(b69.isClickable)
        b69.setOnClickListener(this)
        if(b71.isClickable)
        b71.setOnClickListener(this)
        if(b72.isClickable)
        b72.setOnClickListener(this)
        if(b73.isClickable)
        b73.setOnClickListener(this)
        if(b74.isClickable)
        b74.setOnClickListener(this)
        if(b75.isClickable)
        b75.setOnClickListener(this)
        if(b76.isClickable)
        b76.setOnClickListener(this)
        if(b77.isClickable)
        b77.setOnClickListener(this)
        if(b78.isClickable)
        b78.setOnClickListener(this)
        if(b79.isClickable)
        b79.setOnClickListener(this)
        if(b81.isClickable)
        b81.setOnClickListener(this)
        if(b82.isClickable)
        b82.setOnClickListener(this)
        if(b83.isClickable)
        b83.setOnClickListener(this)
        if(b84.isClickable)
        b84.setOnClickListener(this)
        if(b85.isClickable)
        b85.setOnClickListener(this)
        if(b86.isClickable)
        b86.setOnClickListener(this)
        if(b87.isClickable)
        b87.setOnClickListener(this)
        if(b88.isClickable)
        b88.setOnClickListener(this)
        if(b89.isClickable)
        b89.setOnClickListener(this)
        if(b91.isClickable)
        b91.setOnClickListener(this)
        if(b92.isClickable)
        b92.setOnClickListener(this)
        if(b93.isClickable)
        b93.setOnClickListener(this)
        if(b94.isClickable)
        b94.setOnClickListener(this)
        if(b95.isClickable)
        b95.setOnClickListener(this)
        if(b96.isClickable)
        b96.setOnClickListener(this)
        if(b97.isClickable)
        b97.setOnClickListener(this)
        if(b98.isClickable)
        b98.setOnClickListener(this)
        if(b99.isClickable)
        b99.setOnClickListener(this)

        val clr: Button = view.findViewById(R.id.clear)
        val one: Button = view.findViewById(R.id.one)
        val two: Button = view.findViewById(R.id.two)
        val three: Button = view.findViewById(R.id.three)
        val four: Button = view.findViewById(R.id.four)
        val five: Button = view.findViewById(R.id.five)
        val six: Button = view.findViewById(R.id.six)
        val seven: Button = view.findViewById(R.id.seven)
        val eight: Button = view.findViewById(R.id.eight)
        val nine: Button = view.findViewById(R.id.nine)

        clr.setOnClickListener(this)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)

        val reset:Button = view.findViewById(R.id.resetButton)
        reset.setOnClickListener(this)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        timerVal?.cancel()
    }

    override fun onClick(v: View?) {

        if(v?.isClickable==false)
            return
        when (v?.id){
            R.id.clear -> {
                selectedButton?.text = ""
                if(selectedButton!=null){
                    Log.i("index","${selectedButton!!.id} ${reverseMap[selectedButton]?.get(1)?.toString()?.toInt()} ${reverseMap[selectedButton]?.get(2)?.toString()?.toInt()} ")
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=0
                    }
                }
                return
            }
            R.id.one -> {
                selectedButton?.text = "1"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=1
                    }
                }
                check()
                return
            }
            R.id.two -> {
                selectedButton?.text = "2"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=2
                    }
                }
                check()
                return
            }
            R.id.three -> {
                selectedButton?.text = "3"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=3
                    }
                }
                check()
                return
            }
            R.id.four -> {
                selectedButton?.text = "4"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=4
                    }
                }
                check()
                return
            }
            R.id.five -> {
                selectedButton?.text = "5"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=5
                    }
                }
                check()
                return
            }
            R.id.six -> {
                selectedButton?.text = "6"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=6
                    }
                }
                check()
                return
            }
            R.id.seven -> {
                selectedButton?.text = "7"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=7
                    }
                }
                check()
                return
            }
            R.id.eight -> {
                selectedButton?.text = "8"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=8
                    }
                }
                check()
                return
            }
            R.id.nine -> {
                selectedButton?.text = "9"
                if(selectedButton!=null){
                    val row= reverseMap[selectedButton]?.get(1)?.toString()?.toInt()
                    val col= reverseMap[selectedButton]?.get(2)?.toString()?.toInt()
                    if (col != null && row != null) {
                        userInputBoard[row-1][col-1]=9
                    }
                }
                check()
                return
            }
            R.id.resetButton -> {
                resetBoard()
                return
            }
        }

        if (selectedButton != null){
            selectedButton!!.setBackgroundResource(R.drawable.button_border)
            removeHighlight(selectedButton!!)
        }
        selectedButton = v as Button
        highlight(selectedButton!!)
        selectedButton!!.setBackgroundResource(R.drawable.selected_button_border)
    }

    private fun removeHighlight(button:Button){

        if (selectedButton == null) return

        var row = reverseMap[button]?.get(1)?.toString()?.toInt()
        var col = reverseMap[button]?.get(2)?.toString()?.toInt()

        for (i in 0 until 9){
            if (row != null) {
                if (buttonMap["b${row}${i + 1}"]?.isClickable!!){
                    buttonMap["b${row}${i + 1}"]?.setBackgroundResource(R.drawable.button_border)
                }
            }
        }
        for (i in 0 until 9){
            if (col != null) {
                if (buttonMap["b${i + 1}${col}"]?.isClickable!!){
                    buttonMap["b${i + 1}${col}"]?.setBackgroundResource(R.drawable.button_border)
                }
            }
        }
    }

    private fun highlight(button:Button){

        var row = reverseMap[button]?.get(1)?.toString()?.toInt()
        var col = reverseMap[button]?.get(2)?.toString()?.toInt()

        for (i in 0 until 9){
            if (row != null) {
                if (buttonMap["b${row}${i + 1}"]?.isClickable!!){
                    buttonMap["b${row}${i + 1}"]?.setBackgroundResource(R.drawable.highlighted_button)
                }
            }
        }
        for (i in 0 until 9){
            if (col != null) {
                if (buttonMap["b${i + 1}${col}"]?.isClickable!!){
                    buttonMap["b${i + 1}${col}"]?.setBackgroundResource(R.drawable.highlighted_button)
                }
            }
        }
    }


    private fun resetBoard(){
        if (selectedButton == null) return
        removeHighlight(selectedButton!!)
        selectedButton!!.setBackgroundResource(R.drawable.button_border)
        selectedButton = null
        for (i in 0 until 9){
            for (j in 0 until 9){
                if (buttonMap["b${i+1}${j+1}"]?.isClickable!!){
                    buttonMap["b${i+1}${j+1}"]?.text = ""
                    userInputBoard[i][j] = 0
                }
            }
        }

    }

    private fun check() {
        for(i in 0..8)
            for(j in 0..8){

                if(userInputBoard[i][j]==0)
                {
                    Log.i("check","er 1")
                    return
                }

                for(k in 0..8){
                    if(userInputBoard[i][j]==userInputBoard[i][k] && j!=k)
                    {
                        Log.i("check","er 2 $i $j $k ${userInputBoard[i][j]}")
                        return
                    }
                    if(userInputBoard[i][j]==userInputBoard[k][j] && i!=k)
                    {
                        Log.i("check","er 3 $i $j $k ${userInputBoard[i][j]}")
                        return
                    }
                }
            }
        for(a in 0..2)
            for(b in 0..2){
                for(i in 0..2)
                    for(j in 0..2) {
                        val r = 3 * a
                        val c = 3 * b
                        for (x in 0..2)
                            for (y in 0..2) {
                                if (userInputBoard[i + r][j + c] == userInputBoard[x + r][y + c] && (x != i || y != j))
                                {
                                    Log.i("check","er here")
                                    return
                                }
                            }
                    }
            }
        Toast.makeText(activity,"GREAT JOB!! YOU SOLVED IT!!",Toast.LENGTH_LONG).show()
    }

    private fun generatematrix(){
        solveSudoku(9)
        val uplift = (1..9).random()
        for(i in 0..8)
            for(j in 0..8)
            matrix[i][j]=(matrix[i][j]+uplift)%9 + 1
        for(count in 1..35) {
            val i=(0..8).random()
            val j=(0..8).random()
            val key = "b${(i+1)}${(j+1)}"
            userInputBoard[i][j] = matrix[i][j]
            buttonMap[key]?.text = matrix[i][j].toString()
            buttonMap[key]?.setTextColor(Color.parseColor("#ffffff"))
            buttonMap[key]?.setBackgroundResource(R.drawable.selected_button_border)
            buttonMap[key]?.setTypeface(null,BOLD)
            buttonMap[key]?.isClickable=false
        }
    }


    private fun isSafe(row:Int, col:Int, num:Int):Boolean{

        for (d in 0 until 9){
            if(d==col)
                continue
            if (matrix[row][d] == num){
                return false
            }
        }
        for (r in 0 until 9){
            if(r==row)
                continue
            if (matrix[r][col] == num){
                return false
            }
        }

        val sqrt = 3
        val boxRowStart = row - row % sqrt
        val boxColStart = col - col % sqrt

        for (r in boxRowStart until (boxRowStart+sqrt)){
            for (d in boxColStart until (boxColStart+sqrt)){
                if(d==col && r==row)
                    continue
                if (matrix[r][d] == num)
                    return false
            }
        }
        return true
    }

    private fun solveSudoku(N:Int):Boolean{
        var row = -1
        var col = -1
        var isEmpty = true
        for (i in 0 until N){
            for (j in 0 until N){
                if (matrix[i][j] == 0){
                    row = i
                    col = j
                    isEmpty = false
                    break
                }
            }
            if (!isEmpty){
                break
            }
        }
        if (isEmpty){
            return true
        }
        for (num in 1 until N+1){
            if (isSafe(row, col, num)){
                matrix[row][col] = num
                if (solveSudoku(N)){
                    return true
                }
                else{
                    matrix[row][col] = 0
                }
            }
        }
        return false
    }
}