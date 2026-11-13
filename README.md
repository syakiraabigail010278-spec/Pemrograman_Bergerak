# Tugas Pertemuan 7 — Campus Catalog (Local Data Persistence: Room + DataStore)

Aplikasi Android berbasis Jetpack Compose sebagai kelanjutan dari project Pertemuan 6 pada mata kuliah Pemrograman Bergerak, dengan menerapkan arsitektur *data layer* persisten menggunakan **Room** dan **Preferences DataStore** agar data utama serta preferensi pengguna tetap tersimpan setelah aplikasi ditutup dan dibuka kembali (*close & reopen*).

## Identitas Mahasiswa
- **Nama:** Syakira Abigail Al Wahaby
- **NIM:** 0102523055
- **Tugas:** Pertemuan 7 — Local Data Persistence (Room + DataStore)
- **Mata Kuliah:** Pemrograman Bergerak (3 SKS)
- **Dosen Pengampu:** Dody
- **Program Studi:** Informatika – Universitas Al-Azhar Indonesia

## Ringkasan Arsitektur & Komponen Data Layer

| Lapisan / Komponen | File Utama | Tanggung Jawab |
| :--- | :--- | :--- |
| **UI Layer (Compose)** | `CatalogRoute.kt`, `CatalogScreen.kt` | Menampilkan 3 destination (Katalog, Tambah/Edit, Setting), mengamati `StateFlow`, dan meneruskan event pengguna. |
| **ViewModel** | `CatalogViewModel.kt`, `CatalogUiState.kt` | Menggabungkan aliran `Flow` Room & DataStore via `combine()`, mengelola filter/sort, dan menjalankan operasi CRUD. |
| **Repository** | `CatalogRepository.kt` | *Entry point* tunggal (*Single Source of Truth*) yang memisahkan ViewModel dari detail database dan DataStore. |
| **Room Database 3.0.3** | `AppDatabase.kt`, `CatalogDao.kt`, `CatalogEntity.kt` | Menyimpan data terstruktur tabel `catalog_items` (4 field + primary key) dan menyediakan query reaktif `Flow` serta CRUD. |
| **Preferences DataStore** | `SettingsDataStore.kt` | Menyimpan preferensi pengguna (`dark_mode` dan `sort_ascending`) secara persisten berbasis *key-value*. |

## Fitur Utama Pertemuan 7
1. **Local Database dengan Room 3.0.3 (`androidx.room3`):**
   - Menyimpan daftar katalog kampus secara persisten ke dalam tabel database lokal (`CatalogEntity` dengan 4 field dan *primary key*).
   - Mendukung operasi CRUD lengkap (`observeAll` berbasis `Flow`, `getById`, `insert`, `update`, dan `delete`) melalui `CatalogDao`.
2. **Preferences DataStore 1.3.0:**
   - **Dark Mode (`dark_mode`):** Mengatur tema tampilan aplikasi (mode terang / mode gelap).
   - **Sort Order (`sort_ascending`):** Mengatur urutan daftar item katalog secara Ascending (`A-Z`) atau Descending (`Z-A`).
3. **3 Navigasi Layar Utama (Destinations):**
   - **Katalog:** Menampilkan seluruh daftar item tersimpan, fitur pencarian, reset filter, dan hapus data.
   - **Tambah / Edit:** Formulir untuk menambahkan data baru maupun memperbarui item yang dipilih.
   - **Setting:** Halaman pengaturan preferensi *Dark Mode* dan urutan daftar katalog.

## Cara Menjalankan & Menguji Persistence
1. Buka project ini menggunakan **Android Studio** dan lakukan **Gradle Sync**.
2. Jalankan aplikasi (**Run**) pada emulator atau perangkat Android (Minimal SDK 24).
3. Tambahkan data baru melalui tab **Tambah**, lalu aktifkan **Mode Gelap** dan ubah urutan daftar pada tab **Setting**.
4. Tutup aplikasi sepenuhnya (*force close* dari *Recent Apps*), kemudian buka kembali aplikasi untuk memastikan seluruh data Room dan pengaturan DataStore tetap tersimpan.
