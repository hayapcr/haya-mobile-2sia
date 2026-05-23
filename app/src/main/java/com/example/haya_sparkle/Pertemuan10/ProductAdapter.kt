package com.example.haya_sparkle.Pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.haya_sparkle.databinding.ItemProductBinding

class ProductAdapter(
    private val productList: List<ProductModel>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = productList[position]

        with(holder.binding) {

            tvTitle.text = item.title
            tvCode.text = "Kode: ${item.code}"
            tvYear.text = "Tahun: ${item.year}"
            tvBudget.text = "Anggaran: ${item.budget}"
            tvDescription.text = item.description

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)
        }
    }

    override fun getItemCount(): Int = productList.size
}