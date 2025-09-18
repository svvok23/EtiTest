package com.vstudio.etitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vstudio.etitest.common.ui.theme.EtiTestTheme
import com.vstudio.etitest.navigation.AppNavHost
import com.vstudio.etitest.navigation.AppRouter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            EtiTestApp()
        }
    }
}

@Composable
fun EtiTestApp() {
    EtiTestTheme(
        dynamicColor = false,
        darkTheme = true
    ) {
        val navController = rememberNavController()
        val navigationRouter = remember(navController) {
            AppRouter(navController)
        }

        Surface(modifier = Modifier.fillMaxSize()) {
            AppNavHost(
                navController = navController,
                navigationRouter = navigationRouter
            )
        }
    }
}