package com.example.huisdoktersgent.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.huisdoktersgent.data.local.DokterAndFields
import com.example.huisdoktersgent.databinding.ListItemDokterBinding
import com.example.huisdoktersgent.models.Record

class DokterAdapter(private var dokterClickListener: DokterClickListener): ListAdapter<DokterAndFields, DokterViewHolder>(DokterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        return DokterViewHolder(ListItemDokterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        val dokter = getItem(position)
        holder.bindData(dokter)
        holder.itemView.setOnClickListener {
            dokterClickListener.onDokterClicked(dokter)
        }
    }
}

private class DokterDiffCallback: DiffUtil.ItemCallback<DokterAndFields>(){
    override fun areItemsTheSame(oldItem: DokterAndFields, newItem: DokterAndFields): Boolean {
        return oldItem.dokter.recordid == newItem.dokter.recordid
    }

    override fun areContentsTheSame(oldItem: DokterAndFields, newItem: DokterAndFields): Boolean {
        return oldItem.dokter.equals(newItem.dokter)
    }

}

class DokterViewHolder(val binding: ListItemDokterBinding): RecyclerView.ViewHolder(binding.root){

    fun bindData(dokter: DokterAndFields){
        binding.dokter = dokter
    }
}

interface DokterClickListener{
    fun onDokterClicked(dokter: DokterAndFields)
}