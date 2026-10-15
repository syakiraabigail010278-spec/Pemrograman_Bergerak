package com.example.helloandroid_syakiraabigailalwahaby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductCatalogScreen()
                }
            }
        }
    }
}

// ---------------------------------------------------------------------------
// SCREEN UTAMA
// ---------------------------------------------------------------------------
@Composable
fun ProductCatalogScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp)
        ) {
            // 1. Header Catalog
            CatalogHeader(
                storeName = "Tech Gadget Store",
                itemCount = "3 Produk Tersedia"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 2. Kumpulan Cards Produk
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProductCard(
                    title = "Wireless Headphones Pro",
                    category = "Audio & Electronics",
                    price = "Rp 1.250.000",
                    rating = "4.8"
                )
                ProductCard(
                    title = "Smartwatch Series 5",
                    category = "Wearable Gadget",
                    price = "Rp 2.499.000",
                    rating = "4.9"
                )
                ProductCard(
                    title = "Mechanical Gaming Keyboard",
                    category = "Computer Accessories",
                    price = "Rp 850.000",
                    rating = "4.7"
                )
            }
        }

        // 3. Footer Action
        CatalogFooterAction(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

// ---------------------------------------------------------------------------
// CUSTOM COMPOSABLE 1: Header
// ---------------------------------------------------------------------------
@Composable
fun CatalogHeader(storeName: String, itemCount: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = storeName,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = itemCount,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🛒", fontSize = 20.sp)
            }
        }
    }
}

// ---------------------------------------------------------------------------
// CUSTOM COMPOSABLE 2: Card Produk Reusable
// ---------------------------------------------------------------------------
@Composable
fun ProductCard(
    title: String,
    category: String,
    price: String,
    rating: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title.take(1),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "★", color = Color(0xFFFFB300), fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = rating,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Text(
                text = price,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

// ---------------------------------------------------------------------------
// CUSTOM COMPOSABLE 3: Footer Aksi
// ---------------------------------------------------------------------------
@Composable
fun CatalogFooterAction(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Lihat Semua Produk",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// ---------------------------------------------------------------------------
// PREVIEW ANDROID STUDIO
// ---------------------------------------------------------------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductCatalogPreview() {
    MaterialTheme {
        ProductCatalogScreen()
    }
}