package com.learning.talentprogramming.Ch_12_RecyclerView.CustomListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.talentprogramming.databinding.ListItemViewBinding

class LanguageAdapter (val programmingList : List<String>) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    class LanguageViewHolder(val binding : ListItemViewBinding) : RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        //TODO("Not yet implemented")
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemViewBinding.inflate(layoutInflater)
        return LanguageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return programmingList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val programmingItem = programmingList[position]
        holder.binding.txtLanguage.text = programmingItem
    }


}

