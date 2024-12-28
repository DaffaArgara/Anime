package id.dafaargara.animereview

// Import library yang diperlukan
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Deklarasi kelas MainActivity yang merupakan turunan dari ComponentActivity
class MainActivity : ComponentActivity() {

    // Override fungsi onCreate untuk mengatur apa yang terjadi saat Activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Memanggil implementasi bawaan onCreate dari ComponentActivity

        // Menentukan konten tampilan Activity menggunakan Jetpack Compose
        setContent {
            AnimeReviewApp() // Memanggil fungsi utama aplikasi yang mendefinisikan struktur navigasi dan UI
        }
    }
}
