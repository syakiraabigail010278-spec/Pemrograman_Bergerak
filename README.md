# Tugas Pertemuan 6 — Refactor ViewModel + StateFlow

**Nama:** Syakira Abigail Al Wahaby (Samm)  
**NIM:** 0102523055  
**Prodi:** Informatika - Universitas Al-Azhar Indonesia  
**Dosen:** Pak Dody  

---

## 1. Ringkasan Refactoring
Aplikasi Pertemuan 5/4 telah direfactor dari arsitektur state lokal ke **UI Layer + ViewModel + StateFlow + UDF**:
- **State Holder**: `CatalogViewModel` mengelola state screen menggunakan `MutableStateFlow` (private) dan `StateFlow` (public read-only).
- **Lifecycle-Aware Collection**: `CatalogRoute` mengonsumsi state dengan `collectAsStateWithLifecycle()`.
- **Decoupled UI**: `CatalogScreen` murni menerima state dan callback event (tanpa menyimpan/mengetahui `NavController` atau `ViewModel`).

---

## 2. Event yang Ditangani ViewModel
1. `onQueryChange`: Filter pencarian katalog berdasarkan input pencarian[cite: 1].
2. `onSelectCategory`: Filtering katalog berdasarkan kategori item[cite: 1].
3. `onResetFilter`: Mengembalikan UiState ke kondisi default (reset pencarian)[cite: 1].
4. `onSelectItem`: Menandai item yang dipilih sebelum navigasi detail[cite: 1].

---

## 3. Penanganan Non-Happy Path
Aplikasi menangani kondisi **Empty State** (`uiState.isEmpty`) saat query pencarian tidak cocok dengan item mana pun[cite: 1].

---

## 4. Deklarasi Penggunaan AI
- **Penggunaan AI:** Ya  
- **Tool yang digunakan:** Gemini  
- **Bagian yang dibantu:** Merancang refactoring arsitektur UDF (Route, Screen, ViewModel), memisahkan lifecycle state collection, dan pembuatan template dokumentasi PDF/README.  
- **Apa yang saya ubah/pahami:** Saya memahami pemisahan tanggung jawab antara Route dan Screen, enkapsulasi StateFlow, serta pengujian konsistensi state saat rotasi layar.
