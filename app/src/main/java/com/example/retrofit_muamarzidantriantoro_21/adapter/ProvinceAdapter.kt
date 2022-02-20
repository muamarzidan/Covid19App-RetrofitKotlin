package com.example.retrofit_muamarzidantriantoro_21.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_muamarzidantriantoro_21.Model.ProvinceResponse
import com.example.retrofit_muamarzidantriantoro_21.R

class ProvinceAdapter (private var list: ArrayList<ProvinceResponse>) :
    RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(province: ProvinceResponse){
            with(itemView){
                val tvName : TextView = findViewById(R.id.tvName)
                val tvPositive : TextView = findViewById(R.id.tvPositive)
                val tvRecover : TextView = findViewById(R.id.tvRecover)
                val tvDeath : TextView = findViewById(R.id.tvDeath)

                tvName.text = province.attributes.province
                tvPositive.text = province.attributes.positive.toString()
                tvRecover.text = province.attributes.recover.toString()
                tvDeath.text = province.attributes.death.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}