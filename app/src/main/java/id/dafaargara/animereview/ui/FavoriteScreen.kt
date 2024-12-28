package id.dafaargara.animereview.ui

// Import berbagai elemen dan fungsi yang digunakan dalam aplikasi
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import id.dafaargara.animereview.FavoriteActivity
import id.dafaargara.animereview.MainActivity
import id.dafaargara.animereview.data.Anime
import id.dafaargara.animereview.data.animeList

// Fungsi Composable untuk menampilkan layar FavoriteScreen
@Composable
fun FavoriteScreen(context: Context) {
    // Scaffold menyediakan struktur dasar UI dengan top bar dan bottom bar
    Scaffold(
        topBar = {
            // TopAppBar menampilkan judul layar di bagian atas
            TopAppBar(title = { Text("Anime ID") })
        },
        bottomBar = {
            // Bottom bar dengan dua tombol: Favorite dan Home
            Row {
                // Tombol Favorite
                Button(
                    onClick = {
                        // Intent untuk membuka activity FavoriteActivity
                        val intent = Intent(context, FavoriteActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp) // Memberikan padding pada tombol
                ) {
                    Text(text = "Favorite") // Label tombol
                }
                // Spacer untuk memberikan jarak horizontal antara tombol
                Spacer(modifier = Modifier.width(8.dp))
                // Tombol Home
                Button(
                    onClick = {
                        // Intent untuk membuka activity MainActivity
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp) // Memberikan padding pada tombol
                ) {
                    Text(text = "Home") // Label tombol
                }
            }
        }
    ) { paddingValues -> // Isi utama layar
        // LazyColumn digunakan untuk menampilkan daftar data secara efisien
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // Mengisi seluruh layar
                .padding(paddingValues) // Menambahkan padding dari Scaffold
                .background(Color.White) // Mengatur warna latar belakang
        ) {
            // Menampilkan setiap item dari daftar animeList
            items(animeList) { anime: Anime ->
                // Memanggil fungsi DisplayAnimeItem untuk menampilkan detail setiap anime
                DisplayAnimeItem(anime = anime) {
                    // Handle item click (fungsi untuk navigasi atau aksi lain, belum diimplementasikan)
                }
            }
        }
    }
}
