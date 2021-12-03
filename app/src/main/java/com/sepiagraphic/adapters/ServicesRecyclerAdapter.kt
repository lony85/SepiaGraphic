package com.sepiagraphic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sepiagraphic.model.Category
import com.sepiagraphic.R

class ServicesRecyclerAdapter(val context: Context, val categories: List<Category>,val itemCliked:(Category) -> Unit) :
    RecyclerView.Adapter<ServicesRecyclerAdapter.Holder>() {
    inner class Holder(itemView: View,val itemCliked: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<ImageView>(R.id.services_layout_image)
        val categoryName = itemView.findViewById<TextView>(R.id.services_layout_text)


        fun bindCategory(category: Category, context: Context) {
            val resourceId =
                context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title

            itemView.setOnClickListener { itemCliked(category) }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.services_sample_layout, parent, false)

        return Holder(view,itemCliked)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)

    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}