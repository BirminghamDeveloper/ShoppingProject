package com.example.shoppingproject.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppingproject.data.db.entity.ShoppingItems
import com.example.shoppingproject.data.repository.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepo
): ViewModel() {
    fun upsert(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(items)
    }
    fun delete(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(items)
    }
    fun getAllShoppingItems() = repository.getAllItemsShopping()
}