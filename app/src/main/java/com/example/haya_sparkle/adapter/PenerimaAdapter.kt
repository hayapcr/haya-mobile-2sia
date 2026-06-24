package com.example.haya_sparkle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.haya_sparkle.database.PenerimaEntity
import com.example.haya_sparkle.databinding.ItemPenerimaBinding

class PenerimaAdapter(
    private val list: List<PenerimaEntity>,
    private val onDelete: (PenerimaEntity) -> Unit
) : RecyclerView.Adapter<PenerimaAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemPenerimaBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemPenerimaBinding.inflate(
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
        holder.binding.tvBantuan.text = item.bantuan
        holder.binding.tvKeterangan.text = item.keterangan

        holder.binding.btnHapus.setOnClickListener {
            onDelete(item)
        }
    }

    override fun getItemCount(): Int = list.size
}