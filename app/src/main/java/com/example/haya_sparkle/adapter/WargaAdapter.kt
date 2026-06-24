package com.example.haya_sparkle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.haya_sparkle.database.WargaEntity
import com.example.haya_sparkle.databinding.ItemWargaBinding

class WargaAdapter(
    private val list: List<WargaEntity>,
    private val onDelete: (WargaEntity) -> Unit
): RecyclerView.Adapter<WargaAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemWargaBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemWargaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val item = list[position]

        holder.binding.tvNama.text = item.nama
        holder.binding.tvNik.text = "NIK : ${item.nik}"
        holder.binding.tvAlamat.text = "Alamat : ${item.alamat}"
        holder.binding.tvPekerjaan.text = "Pekerjaan : ${item.pekerjaan}"
        holder.binding.tvKontak.text = "Kontak : ${item.kontak}"

        holder.binding.btnHapus.setOnClickListener {
            onDelete(item)
        }
    }

    override fun getItemCount(): Int = list.size
}