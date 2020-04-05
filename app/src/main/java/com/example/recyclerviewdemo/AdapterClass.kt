package com.example.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.iteam_card.view.*

class AdapterClass(val context : Context, val list1 : List<list>) :RecyclerView.Adapter<AdapterClass.MyViewHolder>(){

    inner class MyViewHolder( iteamView: View) : RecyclerView.ViewHolder(iteamView)
    {
        var currenttext: list??  = null
        var currentposition : Int = 0
        init {
            iteamView.setOnClickListener {
                Toast.makeText(context,currenttext!!.title + "has been clicked",Toast.LENGTH_SHORT).show()
            }
        }
        fun setData(iteam : list?, pos:Int)
        {
            itemView.title.text = iteam!!.title

            this.currenttext = iteam
            this.currentposition = pos

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.iteam_card, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val iteams = list1[position]
        holder.setData(iteams,position)
    }
}