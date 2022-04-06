package com.top.examen_webservice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterCicles(
    private val reviewList: MutableList<Cicle>
) : RecyclerView.Adapter<AdapterCicles.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rvcicles,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bindView(reviewList[position])
    }

    override fun getItemCount(): Int {

        return reviewList.size
    }

    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Nom: TextView = itemView.findViewById(R.id.txtNomCicle)

        fun bindView(postModel: Cicle){
            Nom.text = postModel.nom

        }


    }
}
