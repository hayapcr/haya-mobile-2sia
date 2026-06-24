package com.example.haya_sparkle.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.haya_sparkle.data.model.NewsModel
import com.example.haya_sparkle.databinding.ItemNewsBinding

class NewsAdapter(
    private val newsList: List<NewsModel>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val beritaDesa = listOf(
        Pair(
            "Pendataan Warga Penerima Bantuan Mulai Dilakukan",
            "Admin desa mulai melakukan pendataan warga agar bantuan sosial dapat tersalurkan dengan tepat sasaran."
        ),
        Pair(
            "Program Bantuan Desa Dibuka Lebih Terarah",
            "Melalui SIBANSOS, informasi program bantuan desa dapat dilihat dengan mudah dan transparan."
        ),
        Pair(
            "Layanan Desa Digital Mempermudah Akses Informasi",
            "Warga dapat melihat informasi bantuan dan data desa secara cepat melalui aplikasi."
        ),
        Pair(
            "Pendaftaran Bantuan Pendidikan Dibuka",
            "Program bantuan pendidikan telah dibuka untuk masyarakat yang memenuhi syarat."
        ),
        Pair(
            "Penyaluran Bantuan UMKM Tahap Kedua",
            "Pemerintah desa kembali menyalurkan bantuan modal usaha kepada pelaku UMKM."
        ),
        Pair(
            "Sistem SIBANSOS Mendapat Pembaruan",
            "Pembaruan terbaru meningkatkan kemudahan akses informasi bantuan sosial."
        )
    )

    class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val berita = beritaDesa[position]

        holder.binding.tvNewsSite.text = "Berita Desa"
        holder.binding.tvNewsTitle.text = berita.first
        holder.binding.tvNewsSummary.text = berita.second
    }

    override fun getItemCount(): Int = beritaDesa.size
}