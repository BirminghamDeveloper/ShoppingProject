package com.example.shoppingproject.data.repository

import com.example.shoppingproject.data.db.ShoppingDatabase
import com.example.shoppingproject.data.db.entity.ShoppingItems

class ShoppingRepo(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(items: ShoppingItems) = db.getShoppingDao().upsert(items)
    suspend fun delete(items: ShoppingItems) = db.getShoppingDao().delete(items)
    fun getAllItemsShopping() = db.getShoppingDao().getAllShoppingItems()
}