package com.sepiagraphic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sepiagraphic.R
import com.sepiagraphic.model.AboutWhyUs


class AboutSliderAdapter( val context: Context,val categories:List<AboutWhyUs>):RecyclerView.Adapter<AboutSliderAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val itemtitle : TextView = itemView.findViewById((R.id.WhyUsTitle))
        val itemDetails : TextView = itemView.findViewById((R.id.WhyUsDetails))
        val itemImage : ImageView = itemView.findViewById(R.id.WhyUsImage)

        fun bindCategory (category: AboutWhyUs,context: Context){
            val resouceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)

            itemImage.setImageResource(resouceId)
            itemtitle.text = category.title
            itemDetails.text = category.details
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.slider_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position],context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}


