package com.example.litesegrega

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_layout.view.*
import java.util.Locale
import java.text.NumberFormat

class ResiduoAdapter(private val resiList : List<Residuo>) : RecyclerView.Adapter<ResiduoAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = resiList[position]
        val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))

        holder.image_view.setImageResource(item.img)
        holder.name_txt_view.text = item.name
        holder.value_txt_view.text = f.format(item.price)
        holder.weight_txt_view.text = "%.2f".format(item.weight)

    }

    override fun getItemCount(): Int {
        return resiList.size
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_txt_view: TextView = itemView.list_item_name
        val value_txt_view: TextView = itemView.list_item_value
        val weight_txt_view: TextView = itemView.list_item_weight
        val image_view: ImageView = itemView.list_item_img
    }
}