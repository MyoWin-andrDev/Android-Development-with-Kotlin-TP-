package com.learning.talentprogramming.Ch_12_RecyclerView.CustomOffset

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewOffset(private val leftOffset : Int , private val rightOffset : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(leftOffset, 0, rightOffset ,0)
    }
}