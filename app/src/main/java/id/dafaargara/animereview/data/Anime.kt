// Package declaration untuk mengatur struktur proyek aplikasi
package id.dafaargara.animereview.data

// Import resource dari file R (untuk referensi gambar)
import id.dafaargara.animereview.R

// Deklarasi data class "Anime"
// Data class ini merepresentasikan model data untuk satu entitas anime
data class Anime(
    val title: String, // Judul anime
    val genre: String, // Genre anime
    val rating: String, // Rating anime dalam bentuk String
    val imageResId: Int, // ID resource gambar anime (misalnya dari drawable)
    val prologue: String, // Prolog atau deskripsi singkat cerita anime
    val reviews: List<String> = listOf() // Daftar ulasan tentang anime, default kosong jika tidak diisi
)

// Deklarasi daftar anime (listOf) yang berisi beberapa instance dari data class "Anime"
val animeList = listOf(
    // Instance pertama dari "Anime"
    Anime(
        title = "Blue Exorcist: Beyond the Snow Saga", // Judul
        genre = "Action, Mythology, School", // Genre
        rating = "7.34", // Rating
        imageResId = R.drawable.anime1, // Referensi gambar
        prologue = "Okumura Rin, putra dari Exorcist ...", // Deskripsi cerita
        reviews = listOf( // Ulasan anime
            "A thrilling story with unique characters...",
            "The plot develops in an exciting way...",
            "Great character development and an engaging storyline..."
        )
    ),
    // Instance kedua dari "Anime"
    Anime(
        title = "Blue Lock vs. U-20",
        genre = "Shounen, Sport, Team Sport",
        rating = "7.12",
        imageResId = R.drawable.anime2,
        prologue = "Setelah kekalahan telak di Piala Dunia 2018...",
        reviews = listOf(
            "A captivating sports anime that keeps you on the edge...",
            "The intense football matches and the drive for improvement...",
            "Incredible animation and football sequences..."
        )
    ),
    // Tambahan instance lainnya...
    Anime(
        title = "Bleach: Thousand-Year Blood War - The Conflict",
        genre = "Action, Adventure, Shounen",
        rating = "9.04",
        imageResId = R.drawable.anime3,
        prologue = "Ichigo Kurosaki adalah seorang siswa sekolah menengah biasa...",
        reviews = listOf(
            "An amazing continuation of the Bleach series...",
            "The characters are as dynamic as ever...",
            "A must-watch for long-time Bleach fans..."
        )
    ),
    Anime(
        title = "Orb: On the Movements of the Earth",
        genre = "Drama, Historical, Seinen",
        rating = "8.5",
        imageResId = R.drawable.anime4,
        prologue = "Polandia abad ke-15, Rafał, seorang anak jenius...",
        reviews = listOf(
            "A thought-provoking anime with a deep philosophical narrative...",
            "Great historical setting and intriguing character development...",
            "A slow burn, but the payoff is worth it..."
        )
    ),
    Anime(
        title = "The Healer Who Was Banished From His Party",
        genre = "Action, Adventure, Fantasy",
        rating = "6.4",
        imageResId = R.drawable.anime5,
        prologue = "Seorang penyembuh dikeluarkan dari kelompoknya...",
        reviews = listOf(
            "A charming story with an unexpected twist on the healer trope...",
            "The battles are decent, but the focus on character development...",
            "A decent fantasy adventure but lacking depth in some areas..."
        )
    ),
    Anime(
        title = "Sword Art Online",
        genre = "Action, Military, Video Game",
        rating = "7.4",
        imageResId = R.drawable.anime6,
        prologue = "Di masa depan, permainan daring dunia maya...",
        reviews = listOf(
            "A great start to the Sword Art Online series...",
            "The virtual world-building is immersive...",
            "While the action is thrilling, the character development..."
        )
    ),
    Anime(
        title = "I'll Become a Villainess Who Goes Down in History",
        genre = "Comedy, Fantasy, Isekai",
        rating = "7.42",
        imageResId = R.drawable.anime7,
        prologue = "Alicia adalah putri sulung keluarga bangsawan Williams...",
        reviews = listOf(
            "A fun twist on the isekai genre...",
            "The anime cleverly blends comedy, fantasy, and drama...",
            "With a unique premise and engaging characters..."
        )
    ),
    Anime(
        title = "asuketsu: Fate of the Majority",
        genre = "Action, Drama, Suspense",
        rating = "4.71",
        imageResId = R.drawable.anime8,
        prologue = "Sekelompok lima orang di dunia di mana orang-orang tiba-tiba menghilang...",
        reviews = listOf(
            "The premise is dark and intense, with a lot of moral dilemmas...",
            "A thrilling anime, though some aspects of the plot feel underdeveloped...",
            "The suspense is great, but the character development feels lacking..."
        )
    ),
    Anime(
        title = "Delico's Nursery",
        genre = "Childcare, Fantasy, Mystery",
        rating = "6.82",
        imageResId = R.drawable.anime9,
        prologue = "Dali Delico, seorang bangsawan yang menolak tugas Dewan Pakta Darah...",
        reviews = listOf(
            "A unique blend of fantasy, mystery, and a bit of humor...",
            "The main character's refusal to accept his destiny...",
            "An enjoyable anime with a good mix of mystery..."
        )
    )
)
