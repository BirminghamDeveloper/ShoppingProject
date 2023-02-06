package com.example.shoppingproject.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingproject.R
import com.example.shoppingproject.data.db.entity.ShoppingItems
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingDialog(context: Context, var addDialogListner: AddDialogListner): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isNotEmpty() || amount.isNotEmpty()){
                Toast.makeText(context, "Please Fill the Gap", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val item = ShoppingItems(name, amount.toInt())
            addDialogListner.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
           cancel()
        }
    }
}