package com.example.helloandroid_syakiraabigailalwahaby.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CatalogRoute(
    viewModel: CatalogViewModel = viewModel(),
    onNavigateToDetail: (Int) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    CatalogScreen(
        uiState = uiState,
        onQueryChange = viewModel::onQueryChange,
        onCategorySelect = viewModel::onSelectCategory,
        onResetClick = viewModel::onResetFilter,
        onItemClick = { item ->
            viewModel.onSelectItem(item)
            onNavigateToDetail(item.id)
        }
    )
}