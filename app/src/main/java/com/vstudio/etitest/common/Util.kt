package com.vstudio.etitest.common

import android.os.Build
import android.view.Window
import android.view.WindowInsets
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

fun Window.setNewStatusBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
        decorView.setOnApplyWindowInsetsListener { view, insets ->
            val statusBarInsets = insets.getInsets(WindowInsets.Type.statusBars())
            view.setBackgroundColor(color)

            // Adjust padding to avoid overlap
            view.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }
    } else {
        // For Android 14 and below
        @Suppress("DEPRECATION")
        statusBarColor = color
    }
}

fun Window.setNewNavigationBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
        decorView.setOnApplyWindowInsetsListener { view, insets ->
            val statusBarInsets = insets.getInsets(WindowInsets.Type.navigationBars())
            view.setBackgroundColor(color)

            // Adjust padding to avoid overlap
            view.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }
    } else {
        // For Android 14 and below
        @Suppress("DEPRECATION")
        navigationBarColor = color
    }
}

fun Color.Companion.fromHex(colorString: String) =
    Color(colorString.toColorInt())

val String.Companion.EMPTY: String
    get() = ""

val String.Companion.SPACE: String
    get() = " "