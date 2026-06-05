package com.osamaalek.kiosklauncher

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import com.osamaalek.kiosklauncher.ui.MainActivity

class MyDeviceAdminReceiver: DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
    }

    override fun onLockTaskModeEntering(context: Context, intent: Intent, pkg: String) {
        super.onLockTaskModeEntering(context, intent, pkg)
    }

    override fun onLockTaskModeExiting(context: Context, intent: Intent) {
        super.onLockTaskModeExiting(context, intent)
        val restartIntent = Intent(context, MainActivity::class.java)
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(restartIntent)
    }

}