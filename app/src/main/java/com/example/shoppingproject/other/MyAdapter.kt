package com.example.shoppingproject.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingproject.R
import com.example.shoppingproject.data.db.entity.ShoppingItems
import com.example.shoppingproject.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class MyAdapter(
    var items: List<ShoppingItems>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<MyAdapter.ShoppingViewsHolder>() {

    inner class ShoppingViewsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewsHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewsHolder, position: Int) {
        val currentShoppingItems = items[position]
//      val currentShoppingItems = items.get(position
        holder.itemView.tvName.text = currentShoppingItems.name
        holder.itemView.tvAmount.text = "${currentShoppingItems.amount}"
//      holder.itemView.tvAmount.text = currentShoppingItems.amount.toString()
        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItems)
        }
        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItems.amount++
            viewModel.upsert(currentShoppingItems)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItems.amount > 0){
                currentShoppingItems.amount--
                viewModel.upsert(currentShoppingItems)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}