package id.dafaargara.animereview

// Import library Compose dan Navigation untuk mengatur navigasi antar layar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.dafaargara.animereview.ui.DetailScreen
import id.dafaargara.animereview.ui.FavoriteScreen
import id.dafaargara.animereview.ui.HomeScreen
import id.dafaargara.animereview.viewmodel.AnimeViewModel

// Fungsi utama untuk aplikasi AnimeReview, menggunakan Compose
@Composable
fun AnimeReviewApp() {
    // Membuat NavController untuk mengelola navigasi antar layar
    val navController = rememberNavController()

    // Menginisialisasi ViewModel untuk mengelola data dan logika bisnis
    val viewModel: AnimeViewModel = viewModel()

    // Menentukan struktur navigasi dengan NavHost
    NavHost(
        navController = navController, // Controller untuk navigasi
        startDestination = "home" // Layar awal adalah layar "home"
    ) {
        // Rute untuk layar "home"
        composable("home") {
            HomeScreen(
                viewModel = viewModel, // Mengoper ViewModel ke HomeScreen
                onAnimeSelected = { anime ->
                    // Ketika anime dipilih, set anime sebagai yang terpilih di ViewModel
                    viewModel.selectAnime(anime)
                    // Navigasi ke layar "detail"
                    navController.navigate("detail")
                },
                LocalContext.current // Mengoper konteks lokal ke HomeScreen
            )
        }

        // Rute untuk layar "detail"
        composable("detail") {
            // Mengambil anime yang terpilih dari ViewModel
            val selectedAnime = viewModel.selectedAnime
            // Jika ada anime yang terpilih, tampilkan layar DetailScreen
            if (selectedAnime != null) {
                DetailScreen(
                    anime = selectedAnime, // Mengoper data anime terpilih
                    onBackPressed = ({ /* Tambahkan logika tombol kembali jika diperlukan */ }),
                    LocalContext.current // Mengoper konteks lokal ke DetailScreen
                )
            }
        }

        // Rute untuk layar "favorites"
        composable("favorites") {
            FavoriteScreen(LocalContext.current) // Tampilkan layar FavoriteScreen
        }
    }
}
