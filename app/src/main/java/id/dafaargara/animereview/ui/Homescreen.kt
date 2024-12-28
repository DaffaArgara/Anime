package id.dafaargara.animereview.ui

// Import library dan fungsi yang digunakan
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.dafaargara.animereview.FavoriteActivity
import id.dafaargara.animereview.MainActivity
import id.dafaargara.animereview.data.Anime
import id.dafaargara.animereview.viewmodel.AnimeViewModel

// Fungsi utama untuk layar Home
@Composable
fun HomeScreen(
    viewModel: AnimeViewModel = viewModel(), // ViewModel untuk mengelola data anime
    onAnimeSelected: (Anime) -> Unit, // Callback saat anime dipilih
    context: Context // Konteks untuk navigasi
) {
    val anime = viewModel.animeList // Mendapatkan daftar anime dari ViewModel
    Log.d("HomeScreen", "Anime count: ${anime.size}") // Debug jumlah anime yang tersedia

    // Scaffold untuk mengatur struktur layar
    Scaffold(
        topBar = {
            // TopAppBar menampilkan judul aplikasi
            TopAppBar(title = { Text("Anime ID") })
        },
        bottomBar = {
            // BottomBar dengan dua tombol navigasi: Favorite dan Home
            Row {
                // Tombol untuk membuka layar FavoriteActivity
                Button(
                    onClick = {
                        val intent = Intent(context, FavoriteActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp) // Memberikan padding pada tombol
                ) {
                    Text(text = "Favorite") // Label tombol
                }
                Spacer(modifier = Modifier.width(8.dp)) // Memberikan jarak horizontal
                // Tombol untuk membuka layar MainActivity
                Button(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Home") // Label tombol
                }
            }
        }
    ) { paddingValues ->
        // LazyColumn untuk menampilkan daftar anime
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // Mengisi layar penuh
                .padding(paddingValues) // Menambahkan padding dari Scaffold
                .background(Color.White) // Warna latar belakang
        ) {
            // Menampilkan setiap item dari daftar anime
            items(anime) { animeItem ->
                AnimeItem(animeItem, onAnimeSelected) // Fungsi untuk menampilkan detail anime
            }
        }
    }
}

// Fungsi untuk menampilkan detail satu item anime
@Composable
fun AnimeItem(anime: Anime, onAnimeSelected: (Anime) -> Unit) {
    Log.d("AnimeItem", "Anime Title: ${anime.title}") // Debug judul anime yang diterima

    // Card untuk menampilkan data anime dalam kotak dengan desain menarik
    Card(
        modifier = Modifier
            .fillMaxWidth() // Mengisi lebar layar penuh
            .padding(8.dp) // Memberikan margin
            .clickable {
                // Callback saat item anime diklik
                Log.d("AnimeItem", "Anime Selected: ${anime.title}") // Debug saat anime dipilih
                onAnimeSelected(anime)
            },
        shape = RoundedCornerShape(8.dp), // Bentuk sudut kartu
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Efek bayangan pada kartu
        colors = CardDefaults.cardColors(containerColor = Color.White) // Warna latar kartu
    ) {
        // Kolom untuk menata konten secara vertikal
        Column(
            horizontalAlignment = Alignment.Start, // Penataan konten ke kiri
            modifier = Modifier.padding(8.dp) // Memberikan padding internal
        ) {
            // Menampilkan gambar anime
            Image(
                painter = painterResource(id = anime.imageResId), // Sumber gambar
                contentDescription = anime.title, // Deskripsi gambar
                modifier = Modifier.size(150.dp) // Ukuran gambar
            )
            Spacer(modifier = Modifier.height(8.dp)) // Jarak antara gambar dan teks
            // Menampilkan judul anime
            Text(
                text = anime.title, // Judul anime
                style = MaterialTheme.typography.bodyLarge // Gaya teks
            )
        }
    }
}
