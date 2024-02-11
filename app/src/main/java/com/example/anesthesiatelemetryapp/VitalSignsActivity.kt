package com.example.anesthesiatelemetryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VitalSignsActivity : AppCompatActivity() {

    private var expandButton: Button? = null // button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vital_signs)

        expandButton = findViewById<View>(R.id.expand) as Button

        // when users presses the login button

        // when users presses the login button
        expandButton!!.setOnClickListener(View.OnClickListener() {

            openWaveformActivity() // opens to next page
        })
    }

    fun openWaveformActivity() {
        val intent = Intent(
            this@VitalSignsActivity,
            WaveformActivity::class.java
        )
        startActivity(intent)
    }
}