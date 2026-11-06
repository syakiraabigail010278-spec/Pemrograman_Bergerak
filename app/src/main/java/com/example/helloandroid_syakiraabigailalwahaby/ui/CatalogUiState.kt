package com.example.helloandroid_syakiraabigailalwahaby.ui

import com.example.helloandroid_syakiraabigailalwahaby.model.CatalogItem

data class CatalogUiState(
    val items: List<CatalogItem> = emptyList(),
    val query: String = "",
    val selectedCategory: String = "All",
    val selectedItem: CatalogItem? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    val isEmpty: Boolean get() = items.isEmpty() && !isLoading
}