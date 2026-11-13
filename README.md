# Campus Catalog — Local Data Persistence (Room + DataStore)

Aplikasi Android berbasis Jetpack Compose yang dikembangkan sebagai kelanjutan dari project Pertemuan 6 dengan menerapkan arsitektur *data layer* modern agar data dan preferensi pengguna tersimpan secara persisten setelah aplikasi ditutup dan dibuka kembali (*close & reopen*).

## Identitas Mahasiswa
- **Nama:** Syakira Abigail Al Wahaby
- **NIM:** 0102523055
- **Mata Kuliah:** Pemrograman Bergerak (Pertemuan 7)[cite: 1, 2]
- **Program Studi:** Informatika – Universitas Al-Azhar Indonesia[cite: 1]

## Fitur Utama
1. **Room Database 3.0.3 (`androidx.room3`):**[cite: 1]
   - Menyimpan daftar item katalog kampus secara terstruktur pada tabel `catalog_items` (`CatalogEntity` dengan 4 field: `id`, `name`, `category`, `description`).
   - Mendukung operasi CRUD lengkap (`observeAll` berbasis `Flow`, `getById`, `insert`, `update`, `delete`) melalui `CatalogDao`[cite: 1, 2].
2. **Preferences DataStore 1.3.0 (`androidx.datastore.preferences`):**[cite: 1]
   - Menyimpan 2 preferensi pengguna secara persisten[cite: 2]:
     - **Dark Mode (`dark_mode`):** Mengubah tema aplikasi antara mode terang dan mode gelap.
     - **Sort Order (`sort_ascending`):** Mengatur urutan daftar katalog secara Ascending (`A-Z`) atau Descending (`Z-A`).
3. **Arsitektur Clean Data Layer (UDF):**
   - `UI (CatalogScreen / CatalogRoute)` → `CatalogViewModel` → `CatalogRepository` → `Room (AppDatabase)` & `SettingsDataStore`[cite: 1, 2].
   - `CatalogViewModel` menggabungkan stream `Flow` dari Room dan DataStore menggunakan operator `combine()` menjadi `StateFlow<CatalogUiState>`[cite: 1].
4. **3 Navigasi Utama (Destinations):**[cite: 2]
   - **Katalog:** Menampilkan daftar item, pencarian (*search*), reset filter, dan hapus data.
   - **Tambah / Edit:** Form input untuk menambah item baru atau memperbarui item yang dipilih.
   - **Setting:** Pengaturan *Dark Mode* dan urutan *Ascending/Descending*.

## Struktur Package
```text
com.example.helloandroid_syakiraabigailalwahaby
├── data
│   ├── local
│   │   ├── AppDatabase.kt        # Singleton RoomDatabase dengan BundledSQLiteDriver
│   │   ├── CatalogDao.kt         # Query reaktif Flow & operasi CRUD
│   │   ├── CatalogEntity.kt      # Entity tabel catalog_items & mapper model
│   │   └── SettingsDataStore.kt  # Preferences DataStore (dark_mode & sort_ascending)
│   └── repository
│       └── CatalogRepository.kt  # Entry point tunggal ke Room dan DataStore
├── model
│   └── CatalogItem.kt            # Model data UI
├── ui
│   ├── CatalogRoute.kt           # Penghubung ViewModel StateFlow ke UI & tema
│   ├── CatalogScreen.kt          # Composable 3 destination (Katalog, Tambah, Setting)
│   ├── CatalogUiState.kt         # State UI immutable
│   └── CatalogViewModel.kt       # Pengelola state, filter, sorting, & event CRUD
└── MainActivity.kt               # Inisialisasi Database, DataStore, & ViewModelFactory
