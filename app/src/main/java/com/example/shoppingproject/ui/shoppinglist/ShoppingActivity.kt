package com.example.shoppingproject.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingproject.R
import com.example.shoppingproject.data.db.ShoppingDatabase
import com.example.shoppingproject.data.db.entity.ShoppingItems
import com.example.shoppingproject.data.repository.ShoppingRepo
import com.example.shoppingproject.other.MyAdapter
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepo(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val myAdapter = MyAdapter(listOf(), viewModel)

        rvShoppingItems.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@ShoppingActivity)
        }

        viewModel.getAllShoppingItems().observe(this, Observer {
            myAdapter.items = it
            myAdapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingDialog(this,
            object : AddDialogListner{
                override fun onAddButtonClicked(item: ShoppingItems) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}