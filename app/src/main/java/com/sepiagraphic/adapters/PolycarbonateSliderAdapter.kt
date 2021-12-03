package com.sepiagraphic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sepiagraphic.R
import com.sepiagraphic.model.Polycarbonate

class PolycarbonateSliderAdapter(val context: Context, val categories:List<Polycarbonate>): RecyclerView.Adapter<PolycarbonateSliderAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val itemtitle : TextView = itemView.findViewById((R.id.polycarbonate_title))
        val itemDetail_1 : TextView = itemView.findViewById((R.id.polycarbonate_text_1))
        val itemDetail_2 : TextView = itemView.findViewById((R.id.polycarbonate_text_2))
        val itemDetail_3 : TextView = itemView.findViewById((R.id.polycarbonate_text_3))
        val itemDetail_4 : TextView = itemView.findViewById((R.id.polycarbonate_text_4))

        fun bindCategory (category: Polycarbonate, context: Context){

            itemtitle.text = category.title
            itemDetail_1.text = category.detail_1
            itemDetail_2.text = category.detail_2
            itemDetail_3.text = category.detail_3
            itemDetail_4.text = category.detail_4
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.slider_polycarbonate,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position],context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}