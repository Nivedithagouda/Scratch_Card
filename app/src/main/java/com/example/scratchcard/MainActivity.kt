package com.example.scratchcard

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.scratchcard.ScratchCard.OnScratchListener
import com.example.scratchcard.Utils.generateNewCode

        class MainActivity : AppCompatActivity() {
            private var mScratchCard: ScratchCard? = null
            var codeTxt: TextView? = null
            var number: String? = null
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                mScratchCard = findViewById<ScratchCard>(R.id.scratchCard)
                codeTxt = findViewById<TextView>(R.id.codeTxt)
                number = codeTxt!!.text.toString()
                codeTxt!!.text = number
                codeTxt!!.text = generateNewCode()
                findViewById<View>(R.id.btnScratchAgain).setOnClickListener {
                    finish()
                    startActivity(intent)
                }
            }

            private fun scratch(isScratched: Boolean) {
                if (isScratched) {
                    mScratchCard!!.visibility = View.INVISIBLE
                } else {
                    mScratchCard!!.visibility = View.VISIBLE
                }
            }

            private fun handleListeners() {
                mScratchCard!!.setOnScratchListener(object : OnScratchListener {
                    override fun onScratch(scratchCard: ScratchCard?, visiblePercent: Float) {
                        if (visiblePercent > 0.8) {
                            scratch(true)
                        }
                    }
                })
            }
        }
