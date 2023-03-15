package com.demir.stanbulkartclone.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.databinding.HomeCardItemBinding
import com.demir.stanbulkartclone.databinding.KartlarimItemBinding

class KartlarimAdapter:RecyclerView.Adapter<KartlarimAdapter.KartlarimHolder>() {
    class KartlarimHolder(val binding: KartlarimItemBinding):RecyclerView.ViewHolder(binding.root)
    val colorList= arrayListOf("#e4ebfe","#ffe3e0","#e0f5f6","#ffe3e0")
    val cardList= arrayListOf(R.drawable.mavii,R.drawable.kirmizi,R.drawable.yesil,R.drawable.kirmizi)
    val cardNumber= arrayListOf("4383930283720271","3728930483746372","3389403816351723","3838402948372618")
    val cardBalance= arrayListOf("4,32","41,46","12,76","1,21")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KartlarimHolder {
        val view= KartlarimItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KartlarimHolder(view)
    }

    override fun onBindViewHolder(holder: KartlarimHolder, position: Int) {
       holder.binding.apply {
ikChoise.setImageResource(cardList[position])
           ikCode.text=cardNumber[position]
           turkishLira.text=cardBalance[position]
           cdCardItem.setCardBackgroundColor(Color.parseColor(colorList[position]))
       }
    }

    override fun getItemCount(): Int {
        return 4
    }

}