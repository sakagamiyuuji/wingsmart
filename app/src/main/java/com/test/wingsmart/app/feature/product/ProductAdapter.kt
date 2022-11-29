package com.test.wingsmart.app.feature.product

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.test.wingsmart.app.databinding.ItemProductBinding
import com.test.wingsmart.core.base.BaseBindingAdapter
import com.test.wingsmart.core.base.BaseBindingViewHolder
import com.test.wingsmart.core.util.CurrencyHelper.toRupiahString
import com.test.wingsmart.core.util.showToast
import com.test.wingsmart.domain.model.Product

class ProductAdapter() : BaseBindingAdapter<BaseBindingViewHolder>() {

    var listItems = mutableListOf<Product>()
    var onClick: ((product: Product) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<Product>) {
        listItems.clear()
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        return BaseBindingViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun updateBinding(holder: BaseBindingViewHolder, binding: ViewBinding, position: Int) {
        val bind = binding as ItemProductBinding
        val data = listItems[position]

        holder.itemView.setOnClickListener {
            onClick?.invoke(data)
        }

        with(bind) {
            tvProductName.text = data.productName
            tvProductPrice.text = data.price?.toRupiahString()
            tvProductDiscount.text = data.discountPercentage?.let { discount ->
                tvProductPrice.paintFlags = tvProductPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                ((data.price?.div(100))?.times(discount))?.toRupiahString()
            }
            btnBuy.setOnClickListener {
                context.showToast("Coming Soon")
            }
        }

    }

    companion object {

    }
}