package com.floating.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout =
            android.widget.LinearLayout(this).apply {
                orientation = android.widget.LinearLayout.VERTICAL
                setPadding(50, 50, 50, 50)
                gravity = android.view.Gravity.CENTER
            }

        val title =
            android.widget.TextView(this).apply {
                text = "Floating Home Button\n(Tanpa Iklan & Ringan)"
                textSize = 20f
                gravity = android.view.Gravity.CENTER
                setPadding(0, 0, 0, 40)
            }
        layout.addView(title)

        val btnOverlay =
            Button(this).apply {
                text = "1. Izinkan Tampil di Atas Aplikasi Lain"
                setOnClickListener {
                    if (!Settings.canDrawOverlays(this@MainActivity)) {
                        val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "Izin sudah aktif!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        layout.addView(btnOverlay)

        val btnAccess =
            Button(this).apply {
                text = "2. Aktifkan Layanan Aksesibilitas (Home/Back)"
                setOnClickListener {
                    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                    startActivity(intent)
                }
            }
        layout.addView(btnAccess)

        val btnStart =
            Button(this).apply {
                text = "3. Mulai Floating Button"
                setOnClickListener {
                    if (Settings.canDrawOverlays(this@MainActivity)) {
                        val serviceIntent = Intent(this@MainActivity, FloatingButtonService::class.java)
                        startForegroundService(serviceIntent)
                        Toast.makeText(this@MainActivity, "Floating Button Aktif!", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, "Harap berikan izin tampil di atas aplikasi dulu!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        layout.addView(btnStart)

        setContentView(layout)
    }
}
