package com.pereved.notepad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var itsKotlin = false
    private var text: TextView? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        setListener()
    }

    private fun initUI() {
        text = findViewById(R.id.textView)
        button = findViewById(R.id.button)
    }

    private fun setListener() {
        button!!.setOnClickListener {
            if (!itsKotlin) {
                itsKotlin = true
                text!!.text = getString(R.string.kotlin)
                button!!.text = getString(R.string.to_java)
            } else {
                itsKotlin = false
                text!!.text = getString(R.string.java)
                button!!.text = getString(R.string.to_kotlin)
            }
        }
    }
}