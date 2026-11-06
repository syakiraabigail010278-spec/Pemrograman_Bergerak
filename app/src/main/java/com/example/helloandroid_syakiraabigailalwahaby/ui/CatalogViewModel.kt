package com.example.helloandroid_syakiraabigailalwahaby.ui

import androidx.lifecycle.ViewModel
import com.example.helloandroid_syakiraabigailalwahaby.model.CatalogItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CatalogViewModel : ViewModel() {

    private val sampleItems = listOf(
        CatalogItem(1, "Lab Jaringan & Database", "Fasilitas", "Laboratorium utama Informatika UAI untuk praktikum."),
        CatalogItem(2, "HMIF UAI", "Organisasi", "Himpunan Mahasiswa Informatika Universitas Al-Azhar Indonesia."),
        CatalogItem(3, "Beasiswa Akademik", "Informasi", "Program bantuan biaya pendidikan mahasiswa berprestasi.")
    )

    private val _uiState = MutableStateFlow(CatalogUiState(items = sampleItems))
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _uiState.update { current ->
            val filtered = filterData(newQuery, current.selectedCategory)
            current.copy(query = newQuery, items = filtered)
        }
    }

    fun onSelectCategory(category: String) {
        _uiState.update { current ->
            val filtered = filterData(current.query, category)
            current.copy(selectedCategory = category, items = filtered)
        }
    }

    fun onResetFilter() {
        _uiState.update {
            CatalogUiState(items = sampleItems)
        }
    }

    fun onSelectItem(item: CatalogItem?) {
        _uiState.update { it.copy(selectedItem = item) }
    }

    private fun filterData(query: String, category: String): List<CatalogItem> {
        return sampleItems.filter { item ->
            val matchesQuery = item.name.contains(query, ignoreCase = true) ||
                    item.description.contains(query, ignoreCase = true)
            val matchesCategory = if (category == "All") true else item.category == category
            matchesQuery && matchesCategory
        }
    }
}