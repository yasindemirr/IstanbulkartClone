package com.demir.stanbulkartclone.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.databinding.HomeCardItemBinding

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(val binding: HomeCardItemBinding):RecyclerView.ViewHolder(binding.root)
    val fotoList= arrayListOf<Int>(R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto44)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view=HomeCardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.homeCardImage.setImageResource(fotoList[position%4])
    }

    override fun getItemCount(): Int {
      return 10
    }
}