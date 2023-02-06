package com.example.shoppingproject.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingproject.data.db.entity.ShoppingItems

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(items: ShoppingItems)
    @Delete
    suspend fun delete(items: ShoppingItems)

    @Query("Select * From shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItems>>
}