package com.floating.home

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class HomeAccessibilityService : AccessibilityService() {
    companion object {
        var instance: HomeAccessibilityService? = null
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {}

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    fun goHome(): Boolean = performGlobalAction(GLOBAL_ACTION_HOME)

    fun goBack(): Boolean = performGlobalAction(GLOBAL_ACTION_BACK)

    fun recentApps(): Boolean = performGlobalAction(GLOBAL_ACTION_RECENTS)
}
