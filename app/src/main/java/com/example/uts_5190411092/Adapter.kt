package com.example.uts_5190411092

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (
    val mahasiswa: ArrayList<Model.Data>
    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adpter, parent, false)
        )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val NIM = mahasiswa[position]


        holder.nim.text = NIM.NIM
        holder.nama.text = NIM.Nama
        holder.prodi.text = NIM.PRODI
    }

    override fun getItemCount() = mahasiswa.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nim = view.findViewById<TextView>(R.id.nim)
        val nama = view.findViewById<TextView>(R.id.nama)
        val prodi = view.findViewById<TextView>(R.id.prodi)

    }
    public fun setData(NIM: List<Model.Data>){
        mahasiswa.clear()
        mahasiswa.addAll(NIM)
        notifyDataSetChanged()

    }
}