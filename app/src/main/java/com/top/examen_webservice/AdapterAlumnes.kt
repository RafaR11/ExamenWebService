package com.top.examen_webservice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView


class AdapterAlumnes(
    private val reviewList: MutableList<Alumne>
) : RecyclerView.Adapter<AdapterAlumnes.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rvalumnes,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bindView(reviewList[position])
    }

    override fun getItemCount(): Int {

        return reviewList.size
    }

    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Nom: TextView = itemView.findViewById(R.id.txtNomAlumne)
        val id: TextView = itemView.findViewById(R.id.txtIDAlumne)
        fun bindView(postModel: Alumne){
            Nom.text = postModel.nom
            id.text = postModel.id.toString()
        }


    }
}
