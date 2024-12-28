package id.dafaargara.animereview.ui

// Import berbagai elemen dan fungsi yang digunakan dalam kode
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import id.dafaargara.animereview.FavoriteActivity
import id.dafaargara.animereview.MainActivity
import id.dafaargara.animereview.data.Anime

@Composable
fun DetailScreen(anime: Anime?, onBackPressed: () -> Unit, context: Context) {
    // Scaffold menyediakan struktur dasar UI dengan top bar dan bottom bar
    Scaffold(
        topBar = {
            // TopAppBar menampilkan judul di bagian atas layar
            TopAppBar(title = { Text("Anime ID") })
        },
        bottomBar = {
            // Bottom bar dengan dua tombol: Favorite dan Home
            Row {
                // Tombol Favorite
                Button(
                    onClick = {
                        // Membuka activity FavoriteActivity
                        val intent = Intent(context, FavoriteActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp) // Padding untuk tombol
                ) {
                    Text(text = "Favorite") // Label tombol
                }
                Spacer(modifier = Modifier.width(8.dp)) // Memberikan jarak antara tombol
                // Tombol Home
                Button(
                    onClick = {
                        // Membuka activity MainActivity
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp) // Padding untuk tombol
                ) {
                    Text(text = "Home") // Label tombol
                }
            }
        }
    ) { paddingValues -> // Isi konten layar
        if (anime != null) { // Mengecek apakah data anime tersedia
            // State untuk menyimpan input teks ulasan
            var reviewText by remember { mutableStateOf(TextFieldValue("")) }
            // State untuk menyimpan daftar ulasan yang ditambahkan
            var reviews by remember { mutableStateOf(mutableListOf<String>()) }

            // Kolom utama untuk menampilkan detail anime
            Column(
                modifier = Modifier
                    .fillMaxSize() // Mengisi seluruh layar
                    .padding(paddingValues) // Menghindari area padding scaffold
                    .background(Color.White) // Latar belakang putih
            ) {
                // Menampilkan judul anime
                Text(text = "Title: ${anime.title}", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(10.dp)) // Jarak antar elemen
                // Menampilkan genre dan rating anime
                Text(text = "Genre: ${anime.genre}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Rating: ${anime.rating}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(13.dp)) // Jarak antar elemen
                // Menampilkan prolog anime
                Text(text = "Prologue:", style = MaterialTheme.typography.bodyMedium)
                Text(text = "${anime.prologue}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(10.dp)) // Jarak antar elemen
                // Menampilkan ulasan bawaan
                Text(text = "Reviews:", style = MaterialTheme.typography.bodyMedium)
                anime.reviews.forEach { review ->
                    // Menampilkan setiap ulasan dari data bawaan
                    Text(text = "- $review", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.height(16.dp)) // Jarak antar elemen

                // TextField untuk menambahkan ulasan baru
                TextField(
                    value = reviewText, // Nilai teks yang diinput
                    onValueChange = { reviewText = it }, // Callback saat teks berubah
                    label = { Text("Add a Review") }, // Label TextField
                    modifier = Modifier.fillMaxWidth() // Lebar penuh layar
                )

                Spacer(modifier = Modifier.height(8.dp)) // Jarak antar elemen

                // Tombol untuk submit ulasan
                Button(onClick = {
                    if (reviewText.text.isNotEmpty()) { // Validasi jika input tidak kosong
                        reviews.add(reviewText.text) // Tambahkan ulasan ke daftar
                        reviewText = TextFieldValue("") // Reset TextField setelah submit
                    }
                }) {
                    Text("Submit Review") // Label tombol
                }

                Spacer(modifier = Modifier.height(16.dp)) // Jarak antar elemen

                // Menampilkan daftar ulasan yang ditambahkan
                reviews.forEach { review ->
                    Text(text = review, modifier = Modifier.padding(8.dp)) // Tampilkan setiap ulasan
                }
            }
        }
    }
}
