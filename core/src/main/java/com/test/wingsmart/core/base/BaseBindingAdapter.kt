package com.test.wingsmart.core.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseBindingAdapter<T : BaseBindingViewHolder> : RecyclerView.Adapter<T>() {

    lateinit var context: Context

    override fun onBindViewHolder(holder: T, position: Int) {
        context = holder.binding.root.context
        updateBinding(holder, holder.binding, position)
    }

    protected abstract fun updateBinding(holder: T,
                                         binding: ViewBinding, position: Int)

}