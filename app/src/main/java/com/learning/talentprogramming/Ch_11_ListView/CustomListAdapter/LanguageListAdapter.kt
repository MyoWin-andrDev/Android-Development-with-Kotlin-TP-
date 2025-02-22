package com.learning.talentprogramming.Ch_11_ListView.CustomListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.learning.talentprogramming.databinding.ListItemViewBinding

class LanguageListAdapter(private val programmingList : List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return programmingList.size
    }

    override fun getItem(position : Int): Any {
        //TODO("Not yet implemented")
        return programmingList[position]
    }

    override fun getItemId(position : Int): Long {
        //TODO("Not yet implemented")
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //TODO("Not yet implemented")
        var v = convertView
        if (v == null) {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val binding = ListItemViewBinding.inflate(layoutInflater, parent, false)
            v = binding.root
            binding.txtLanguage.text = programmingList[position]
        }
        return v
    }
}