package com.example.myapplication

import android.media.Image
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var showInstruct : ImageButton
    private lateinit var showCap : ImageButton
    private lateinit var showEspresso : ImageButton
    private lateinit var showWhite : ImageButton
    private lateinit var showLatte : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showInstruct = findViewById(R.id.instBtn)
        showInstruct.setOnClickListener {
            showPopup()
        }
        showCap = findViewById(R.id.C1)
        showCap.setOnClickListener {
            PopCap()
        }
        showEspresso = findViewById(R.id.c2)
        showEspresso.setOnClickListener {
            popEspresso()
        }
        showWhite = findViewById(R.id.c3)
        showWhite.setOnClickListener {
            popWhite()
        }
        showLatte = findViewById(R.id.c4)
        showLatte.setOnClickListener {
            popLatte()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_popup, null)

        val width = 900
        val height = 1900

        val instructWindow = PopupWindow(popupView, width, height, true)
        instructWindow.showAtLocation(popupView, Gravity.CENTER, 20, 100)

        val closeButton = popupView.findViewById<ImageButton>(R.id.closeBtn)
        closeButton.setOnClickListener {
            instructWindow.dismiss()
        }
    }
    private fun PopCap(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupCap = inflater.inflate(R.layout.activity_cappucino_popup,null)

        val width = 900
        val height = 1600

        val iwindow = PopupWindow(popupCap, width, height, true)
        iwindow.showAtLocation(popupCap, Gravity.CENTER, 20, 100)

        val cBtn = popupCap.findViewById<ImageButton>(R.id.cONE)
        cBtn.setOnClickListener {
            iwindow.dismiss()
        }
    }
    private fun popEspresso(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupEsp = inflater.inflate(R.layout.activity_espresso_popup, null)

        val width = 900
        val height = 1600

        val inwindow = PopupWindow(popupEsp, width, height, true)
        inwindow.showAtLocation(popupEsp, Gravity.CENTER, 20, 100)

        val clBtn = popupEsp.findViewById<ImageButton>(R.id.cTWO)
        clBtn.setOnClickListener {
            inwindow.dismiss()
        }
    }
    private fun popWhite(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupWhite = inflater.inflate(R.layout.activity_white_popup,null)

        val width = 900
        val height = 1600

        val insWindow = PopupWindow(popupWhite, width, height, true)
        insWindow.showAtLocation(popupWhite, Gravity.CENTER,20,100)

        val cloBtn = popupWhite.findViewById<ImageButton>(R.id.cTHREE)
        cloBtn.setOnClickListener {
            insWindow.dismiss()
        }
    }
    private fun popLatte(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupLatte = inflater.inflate(R.layout.activity_latte_popup, null)

        val width = 900
        val height = 1600

        val instWindow = PopupWindow(popupLatte, width, height, true)
        instWindow.showAtLocation(popupLatte, Gravity.CENTER, 20, 100)

        val closBtn = popupLatte.findViewById<ImageButton>(R.id.cFOUR)
        closBtn.setOnClickListener {
            instWindow.dismiss()
        }
    }
}