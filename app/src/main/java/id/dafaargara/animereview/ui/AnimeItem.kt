// Package deklarasi untuk lokasi file di dalam proyek
package id.dafaargara.animereview.ui

// Import untuk utilitas dan komponen yang dibutuhkan dalam file ini
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.dafaargara.animereview.data.Anime // Mengimpor data model Anime

// Fungsi Composable untuk menampilkan item Anime
@Composable
fun DisplayAnimeItem(anime: Anime, onAnimeSelected: (Anime) -> Unit) {
    // Logging untuk tujuan debugging saat fungsi dipanggil
    Log.d("DisplayAnimeItem", "Displaying: ${anime.title}")

    // Membuat kartu untuk menampilkan data anime
    Card(
        modifier = Modifier
            .fillMaxWidth() // Memenuhi lebar penuh layar
            .padding(8.dp) // Memberikan jarak di sekitar kartu
            .clickable { onAnimeSelected(anime) }, // Klik kartu akan memanggil callback
        shape = RoundedCornerShape(8.dp), // Bentuk kartu dengan sudut membulat
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Efek bayangan
        colors = CardDefaults.cardColors(containerColor = Color.White) // Warna latar belakang kartu
    ) {
        // Kolom untuk mengatur elemen secara vertikal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Elemen dalam kolom di tengah horizontal
            modifier = Modifier.padding(8.dp) // Memberikan padding di dalam kolom
        ) {
            // Menampilkan gambar anime menggunakan ID resource
            Image(
                painter = painterResource(id = anime.imageResId),
                contentDescription = anime.title, // Deskripsi gambar untuk aksesibilitas
                modifier = Modifier.size(150.dp) // Ukuran gambar
            )
            Spacer(modifier = Modifier.height(8.dp)) // Jarak antara elemen

            // Menampilkan judul anime
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyLarge // Gaya teks sesuai tema Material
            )
            // Menampilkan genre anime
            Text(
                text = "Genre: ${anime.genre}",
                style = MaterialTheme.typography.bodySmall
            )
            // Menampilkan rating anime
            Text(
                text = "Rating: ${anime.rating}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp)) // Jarak tambahan

            // Menampilkan prolog anime
            Text(
                text = "Prologue: ${anime.prologue}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray // Warna teks abu-abu untuk membedakan
            )

            // Jika ada ulasan, tampilkan daftar ulasan
            if (anime.reviews.isNotEmpty()) {
                Text(text = "Reviews:", style = MaterialTheme.typography.bodyMedium) // Header ulasan
                // Iterasi melalui daftar ulasan dan menampilkan masing-masing
                anime.reviews.forEach { review ->
                    Text(
                        text = "- $review", // Teks ulasan dengan tanda titik
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 8.dp) // Padding kiri untuk indentasi
                    )
                }
            } else {
                // Jika tidak ada ulasan, tampilkan pesan ini
                Text(text = "No reviews yet.", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
