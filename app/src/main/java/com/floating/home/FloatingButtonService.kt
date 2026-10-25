package com.floating.home

import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class FloatingButtonService : Service() {
    private lateinit var windowManager: WindowManager
    private lateinit var floatingView: View
    private lateinit var menuLayout: LinearLayout
    private var isMenuOpen = false

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        // Buat Floating Button Utama (Titik Mengambang)
        val btnSize = 130
        floatingView =
            ImageView(this).apply {
                setImageResource(android.R.drawable.ic_menu_compass)
                setBackgroundColor(0xAA000000.toInt())
                setPadding(20, 20, 20, 20)
            }

        // Buat Menu Navigasi (Home, Back, Recent)
        menuLayout =
            LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                visibility = View.GONE
                setBackgroundColor(0xCC000000.toInt())
                setPadding(20, 20, 20, 20)

                addView(
                    createMenuButton("🏠 HOME") {
                        HomeAccessibilityService.instance?.goHome()
                        toggleMenu()
                    },
                )
                addView(
                    createMenuButton("🔙 BACK") {
                        HomeAccessibilityService.instance?.goBack()
                        toggleMenu()
                    },
                )
                addView(
                    createMenuButton("🔲 RECENT") {
                        HomeAccessibilityService.instance?.recentApps()
                        toggleMenu()
                    },
                )
            }

        val params =
            WindowManager
                .LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT,
                ).apply {
                    gravity = Gravity.TOP or Gravity.START
                    x = 100
                    y = 300
                }

        val menuParams =
            WindowManager
                .LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT,
                ).apply {
                    gravity = Gravity.TOP or Gravity.START
                    x = 150
                    y = 300
                }

        // Touch Listener untuk Drag & Click Floating Button
        var initialX = 0
        var initialY = 0
        var initialTouchX = 0f
        var initialTouchY = 0f
        var isMoving = false

        floatingView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = params.x
                    initialY = params.y
                    initialTouchX = event.rawX
                    initialTouchY = event.rawY
                    isMoving = false
                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    val dx = (event.rawX - initialTouchX).toInt()
                    val dy = (event.rawY - initialTouchY).toInt()
                    if (Math.abs(dx) > 5 || Math.abs(dy) > 5) {
                        isMoving = true
                    }
                    params.x = initialX + dx
                    params.y = initialY + dy
                    windowManager.updateViewLayout(floatingView, params)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    if (!isMoving) {
                        toggleMenu()
                    }
                    true
                }

                else -> {
                    false
                }
            }
        }

        windowManager.addView(floatingView, params)
        windowManager.addView(menuLayout, menuParams)
    }

    private fun createMenuButton(
        text: String,
        onClick: () -> Unit,
    ): android.widget.Button =
        android.widget.Button(this).apply {
            this.text = text
            setTextColor(0xFFFFFFFF.toInt())
            setBackgroundColor(0x00000000)
            setOnClickListener { onClick() }
        }

    private fun toggleMenu() {
        isMenuOpen = !isMenuOpen
        menuLayout.visibility = if (isMenuOpen) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::floatingView.isInitialized) windowManager.removeView(floatingView)
        if (::menuLayout.isInitialized) windowManager.removeView(menuLayout)
    }
}
