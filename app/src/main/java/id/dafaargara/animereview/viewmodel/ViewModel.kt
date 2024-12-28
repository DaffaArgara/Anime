package id.dafaargara.animereview.viewmodel

// Import library yang digunakan untuk mendukung Compose dan ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import id.dafaargara.animereview.data.Anime

// Kelas ViewModel untuk mengelola data dan logika bisnis terkait anime
class AnimeViewModel : ViewModel() {

    // Daftar anime yang tersedia
    val animeList = id.dafaargara.animereview.data.animeList
    // Daftar ini diasumsikan sudah diisi dengan data anime yang sesuai

    // Mutable state untuk anime yang dipilih
    var selectedAnime: Anime? by mutableStateOf(null)
        private set // Setter bersifat privat agar hanya dapat diubah dari dalam ViewModel

    // Mutable state untuk teks ulasan/review
    var reviewText by mutableStateOf(TextFieldValue(""))

    // Mutable list untuk daftar anime favorit
    val favorites = mutableStateListOf<Anime>()

    // Fungsi untuk memilih anime tertentu
    fun selectAnime(anime: Anime) {
        selectedAnime = anime // Mengubah state `selectedAnime` menjadi anime yang dipilih
    }

    // Fungsi untuk memperbarui teks ulasan
    fun updateReviewText(newText: TextFieldValue) {
        reviewText = newText // Mengatur teks ulasan dengan nilai baru
    }

    // Fungsi untuk mengirim ulasan (implementasi dapat disesuaikan dengan kebutuhan)
    fun submitReview() {
        // Tambahkan logika untuk menangani pengiriman ulasan
    }

    // Fungsi untuk mendapatkan daftar ulasan untuk anime tertentu
    fun getReviewsForAnime(anime: Anime): List<String> {
        // Mengembalikan daftar ulasan terkait anime
        return listOf() // Ganti dengan logika pengambilan data ulasan yang sebenarnya
    }

    // Fungsi untuk menambahkan anime ke daftar favorit
    fun addToFavorites(anime: Anime) {
        if (!favorites.contains(anime)) { // Memeriksa apakah anime sudah ada di daftar favorit
            favorites.add(anime) // Menambahkan anime ke daftar favorit jika belum ada
        }
    }

    // Fungsi untuk menghapus anime dari daftar favorit
    fun removeFromFavorites(anime: Anime) {
        favorites.remove(anime) // Menghapus anime dari daftar favorit
    }
}
