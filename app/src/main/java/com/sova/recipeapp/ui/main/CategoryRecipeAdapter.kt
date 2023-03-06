package com.sova.recipeapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_category.view.*
import com.sova.recipeapp.BuildConfig.PREVIEW
import com.sova.recipeapp.R
import com.sova.recipeapp.model.Category
import com.sova.recipeapp.ui.category.CategoryActivity

class CategoryRecipeAdapter(
    private val context: Context,
    private val data: List<Category>
) : RecyclerView.Adapter<CategoryRecipeAdapter.MyHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        MyHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_category, p0, false))


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val view = holder.itemView
        Glide.with(context).load(data[position].strCategoryThumb).into(view.iv_category)
        view.tv_category.text = data[position].strCategory

        view.setOnClickListener {
            val intent = Intent(context, CategoryActivity::class.java)
            intent.putExtra("category", data[position].strCategory)
            context.startActivity(intent)
        }

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}