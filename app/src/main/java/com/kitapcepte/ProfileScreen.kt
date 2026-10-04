package com.kitapcepte

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(Material3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Profilim", fontWeight = FontWeight.Bold) })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Varsayılan Profil İkonu
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profil Resmi",
                    modifier = Modifier.size(100.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Kullanıcı Örnek Bilgileri
            Text(text = "Emine Burnak", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "emine.burnak@email.com", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Üyelik: Ekim 2026", fontSize = 12.sp, color = Color.LightGray)

            Spacer(modifier = Modifier.height(32.dp))

            // İstatistik Kartları (Okunan ve Favori Kitaplar)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.width(140.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Book, contentDescription = "Okunan", tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "12", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Okunan", fontSize = 12.sp, color = Color.Gray)
                    }
                }

                Card(
                    modifier = Modifier.width(140.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favoriler", tint = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "7", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Favoriler", fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            // Çıkış Yap Butonu
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Çıkış Yap", color = Color.White)
            }
        }
    }
}

