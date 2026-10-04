package com.kitapcepte

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.srdrakcay.kitapcepte.ui.profile.ProfileScreen
import com.srdrakcay.kitapcepte.ui.profile.ProfileViewModel

@Composable
fun KitapCepteNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route // Uygulama Ana Sayfa ile açılacak
    ) {
        // 1. Ana Sayfa Rotası
        composable(route = BottomBarScreen.Home.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "KitapCepte Ana Sayfasına Hoş Geldiniz!")
            }
        }

        // 2. Profil Sayfası Rotası (Ödevinizin Asıl Kısmı)
        composable(route = BottomBarScreen.Profile.route) {
            val profileViewModel: ProfileViewModel = viewModel()
            ProfileScreen(viewModel = profileViewModel)
        }
    }
}

