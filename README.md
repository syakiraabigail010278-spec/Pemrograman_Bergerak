# Tugas Pertemuan 7 — Campus Catalog (Local Data Persistence: Room + DataStore)

Aplikasi Android berbasis Jetpack Compose sebagai kelanjutan dari project Pertemuan 6 pada mata kuliah Pemrograman Bergerak, dengan menerapkan arsitektur *data layer* persisten menggunakan **Room** dan **Preferences DataStore** agar data utama serta preferensi pengguna tetap tersimpan setelah aplikasi ditutup dan dibuka kembali (*close & reopen*)[cite: 1, 2].

## Identitas Mahasiswa
- **Nama:** Syakira Abigail Al Wahaby
- **NIM:** 0102523055
- **Tugas:** Pertemuan 7 — Local Data Persistence (Room + DataStore)[cite: 1, 2]
- **Mata Kuliah:** Pemrograman Bergerak (3 SKS)[cite: 1]
- **Dosen Pengampu:** Dody[cite: 1, 2]
- **Program Studi:** Informatika – Universitas Al-Azhar Indonesia[cite: 1]

## Fitur Utama Pertemuan 7
1. **Local Database dengan Room 3.0.3 (`androidx.room3`):**[cite: 1]
   - Menyimpan daftar katalog kampus secara persisten ke dalam tabel database lokal (`CatalogEntity` dengan 4 field dan *primary key*)[cite: 2].
   - Mendukung operasi CRUD lengkap (`observeAll` berbasis `Flow`, `getById`, `insert`, `update`, dan `delete`) melalui `CatalogDao`[cite: 1, 2].
2. **Preferences DataStore 1.3.0:**[cite: 1]
   - Menyimpan 2 preferensi pengguna secara persisten[cite: 2]:
     - **Dark Mode (`dark_mode`):** Mengatur tema tampilan aplikasi (mode terang / mode gelap).
     - **Sort Order (`sort_ascending`):** Mengatur urutan daftar item katalog secara Ascending (`A-Z`) atau Descending (`Z-A`).
3. **Arsitektur Data Layer (Unidirectional Data Flow):**
   - Pemisahan tanggung jawab melalui alur `Compose UI` → `CatalogViewModel` → `CatalogRepository` → `Room Database` & `SettingsDataStore`[cite: 1, 2].
   - `CatalogViewModel` menggabungkan aliran data `Flow` dari Room dan DataStore ke dalam `StateFlow<CatalogUiState>` sehingga tampilan diperbarui secara reaktif[cite: 1].
4. **3 Navigasi Layar Utama (Destinations):**[cite: 2]
   - **Katalog:** Menampilkan seluruh daftar item tersimpan, fitur pencarian, reset filter, dan hapus data.
   - **Tambah / Edit:** Formulir untuk menambahkan data baru maupun memperbarui item yang dipilih.
   - **Setting:** Halaman pengaturan preferensi *Dark Mode* dan urutan daftar katalog.

## Cara Menjalankan & Menguji Persistence
1. Buka project ini menggunakan **Android Studio** dan lakukan **Gradle Sync**.
2. Jalankan aplikasi (**Run**) pada emulator atau perangkat Android (Minimal SDK 24).
3. Tambahkan data baru melalui tab **Tambah**, lalu aktifkan **Mode Gelap** dan ubah urutan daftar pada tab **Setting**.
4. Tutup aplikasi sepenuhnya (*force close* dari *Recent Apps*), kemudian buka kembali aplikasi untuk memastikan seluruh data Room dan pengaturan DataStore tetap tersimpan[cite: 1, 2].
