package com.example.shoppingproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingproject.data.db.entity.ShoppingItems

@Database(
    entities = [ShoppingItems::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase? = null
        private var lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createData(context).also { instance = it }
        }
        private fun createData(context: Context) = Room.databaseBuilder(
            context.applicationContext,
        ShoppingDatabase::class.java,
        "ShoppingDB.db").build()
    }
}