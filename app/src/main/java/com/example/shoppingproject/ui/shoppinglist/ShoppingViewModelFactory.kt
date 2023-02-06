package com.example.shoppingproject.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingproject.data.repository.ShoppingRepo

class ShoppingViewModelFactory(
    private val repository: ShoppingRepo
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}