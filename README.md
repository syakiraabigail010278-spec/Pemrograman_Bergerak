# Tugas 4 - Interactive Compose State Challenge

Aplikasi Android berbasis Jetpack Compose & Material 3 untuk mengelola pengaturan aplikasi (Preferences) secara interaktif menggunakan state management, event handling, recomposition, validation, dan state hoisting.

## Informasi Mahasiswa
- **Mata Kuliah**: Pemrograman Aplikasi Bergerak
- **Nama**: Syakira Abigail Al Wahaby
- **NIM**: 0102523055
- **Tema UI**: Pengaturan Aplikasi / Preferences (Digit Terakhir NIM: 5)

## Fitur Utama Aplikasi
1. **Input Teks Interaktif**: Input Nama Pengguna dan Email dengan validasi format instan.
2. **Kontrol Numerik**: Pengatur ukuran teks UI (`fontSize`) berbasis counter.
3. **Toggle Switch**: Switch pengatur status notifikasi aplikasi (Stateless Component).
4. **Validasi & Feedback Langsung**: Pesan peringatan real-time dan tombol Simpan otomatis aktif saat input valid.
5. **Reset State**: Tombol Reset untuk mengembalikan seluruh form ke nilai default.
6. **State Persistence**: Menggunakan `rememberSaveable` agar data input tidak hilang saat perubahan orientasi layar.

## Tabel State Management
| Nama State | Tipe Data | Owner Composable | Dipakai oleh / Fungsi |
| :--- | :--- | :--- | :--- |
| `username` | `String` | `PreferencesScreen` | `OutlinedTextField`, Validasi `isUsernameValid` |
| `email` | `String` | `PreferencesScreen` | `OutlinedTextField`, Validasi `isEmailValid` |
| `notificationEnabled` | `Boolean` | `PreferencesScreen` | `NotificationPreferenceSwitch` |
| `fontSize` | `Int` | `PreferencesScreen` | `FontSizeCounter` |

## Cara Menjalankan Aplikasi
1. Clone repository ini:
   ```bash
   git clone [https://github.com/syakiraabigail010278-spec/Pemrograman_Bergerak.git](https://github.com/syakiraabigail010278-spec/Pemrograman_Bergerak.git)
