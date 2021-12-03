package com.sepiagraphic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sepiagraphic.R
import com.sepiagraphic.model.Category

class ServiceDetailRecyclerAdapter(val context: Context, val categories: List<Category>,val itemClicked:(Category) -> Unit) :RecyclerView.Adapter<ServiceDetailRecyclerAdapter.Holder>() {
    inner class Holder(itemView: View,itemClicked: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<ImageView>(R.id.serviceDetailImage)


        fun bindCategory(category: Category, context: Context) {
            val resourceId =
                context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)

            itemView.setOnClickListener { itemClicked(category) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceDetailRecyclerAdapter.Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.service_detail_layout, parent, false)

        return Holder(view,itemClicked)
    }

    override fun onBindViewHolder(holder: ServiceDetailRecyclerAdapter.Holder, position: Int) {
        holder.bindCategory(categories[position], context)

    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}