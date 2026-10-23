package com.example.helloandroid_syakiraabigailalwahaby

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PreferencesScreen() {
    // State Management (rememberSaveable untuk data input & remember untuk UI sederhana)
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var notificationEnabled by rememberSaveable { mutableStateOf(false) }
    var fontSize by remember { mutableStateOf(14) }

    // Validasi Input (Derived State)
    val isUsernameValid = username.trim().length >= 3
    val isEmailValid = email.contains("@") && email.contains(".")
    val isFormValid = isUsernameValid && isEmailValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Pengaturan Pengguna",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Input 1: Nama Pengguna
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nama Pengguna (Min. 3 Karakter)") },
            isError = username.isNotEmpty() && !isUsernameValid,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Input 2: Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Pengguna") },
            isError = email.isNotEmpty() && !isEmailValid,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        HorizontalDivider()

        // State Hoisting: Switch Component
        NotificationPreferenceSwitch(
            checked = notificationEnabled,
            onCheckedChange = { notificationEnabled = it }
        )

        HorizontalDivider()

        // State Hoisting: Counter Component
        FontSizeCounter(
            fontSize = fontSize,
            onIncrease = { if (fontSize < 24) fontSize += 2 },
            onDecrease = { if (fontSize > 10) fontSize -= 2 }
        )

        HorizontalDivider()

        // Direct Feedback UI
        if (isFormValid) {
            Text(
                text = "✓ Pengaturan valid dan siap disimpan.",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        } else {
            Text(
                text = "⚠️ Mohon isi Nama Pengguna (min 3 karakter) dan Email valid.",
                color = MaterialTheme.colorScheme.error,
                fontSize = 13.sp
            )
        }

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Tombol Reset State
            OutlinedButton(
                onClick = {
                    username = ""
                    email = ""
                    notificationEnabled = false
                    fontSize = 14
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }

            // Tombol Simpan
            Button(
                onClick = { /* Aksi simpan data */ },
                enabled = isFormValid,
                modifier = Modifier.weight(1f)
            ) {
                Text("Simpan")
            }
        }
    }
}

// Stateless Component 1: Switch
@Composable
fun NotificationPreferenceSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Notifikasi Aplikasi", fontWeight = FontWeight.SemiBold)
            Text(
                text = if (checked) "Notifikasi Aktif" else "Notifikasi Nonaktif",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

// Stateless Component 2: Counter
@Composable
fun FontSizeCounter(
    fontSize: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Ukuran Teks UI", fontWeight = FontWeight.SemiBold)
            Text(
                text = "$fontSize sp",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(onClick = onDecrease, enabled = fontSize > 10) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(onClick = onIncrease, enabled = fontSize < 24) {
                Text("+")
            }
        }
    }
}