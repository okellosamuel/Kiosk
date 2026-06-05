package com.osamaalek.kiosklauncher.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osamaalek.kiosklauncher.R
import com.osamaalek.kiosklauncher.util.KioskUtil
import android.view.WindowManager
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
        
        setContentView(R.layout.activity_main)

        KioskUtil.startKioskMode(this)
    }

    override fun onStart() {
        super.onStart()
        KioskUtil.startKioskMode(this)
    }
    override fun onResume() {
        super.onResume()
        // If we are in single app mode, we want to make sure the app is launched when we return to home
        // The HomeFragment.onResume() will handle the auto-launch if SINGLE_APP_PACKAGE is set.
    }
    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) is AppsListFragment) {
            supportFragmentManager.popBackStack()
        }
    }
}