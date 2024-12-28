package id.dafaargara.animereview

// Import library yang diperlukan
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import id.dafaargara.animereview.ui.FavoriteScreen

// Deklarasi kelas FavoriteActivity yang merupakan turunan dari ComponentActivity
class FavoriteActivity : ComponentActivity() {

    // Override fungsi onCreate untuk mengatur apa yang terjadi saat Activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Memanggil implementasi onCreate dari superclass

        // Menentukan konten tampilan Activity menggunakan Compose
        setContent {
            // Menampilkan layar FavoriteScreen
            FavoriteScreen(
                LocalContext.current // Memberikan konteks lokal untuk FavoriteScreen
            )
        }
    }
}
