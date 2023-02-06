package com.example.shoppingproject.ui.shoppinglist

import com.example.shoppingproject.data.db.entity.ShoppingItems

interface AddDialogListner{
    fun onAddButtonClicked(item: ShoppingItems)
}