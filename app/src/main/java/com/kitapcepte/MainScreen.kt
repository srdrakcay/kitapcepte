package com.kitapcepte

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            // Yazdığımız alt menüyü buraya bağlıyoruz
            KitapCepteBottomBar(navController = navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // Sayfa geçişlerini yöneten NavHost'u buraya bağlıyoruz
            KitapCepteNavHost(navController = navController)
        }
    }
}

