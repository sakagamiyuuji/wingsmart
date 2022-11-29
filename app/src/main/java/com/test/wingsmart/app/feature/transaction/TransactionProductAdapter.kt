package com.test.wingsmart.app.feature.transaction

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.test.wingsmart.app.databinding.ItemProductBinding
import com.test.wingsmart.app.databinding.ItemProductTransactionBinding
import com.test.wingsmart.core.base.BaseBindingAdapter
import com.test.wingsmart.core.base.BaseBindingViewHolder
import com.test.wingsmart.core.util.CurrencyHelper.toRupiahString
import com.test.wingsmart.core.util.showToast
import com.test.wingsmart.domain.model.Product

class TransactionProductAdapter() : BaseBindingAdapter<BaseBindingViewHolder>() {

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
            ItemProductTransactionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun updateBinding(holder: BaseBindingViewHolder, binding: ViewBinding, position: Int) {
        val bind = binding as ItemProductTransactionBinding
        val data = listItems[position]

        holder.itemView.setOnClickListener {
            onClick?.invoke(data)
        }

        with(bind) {
            tvProductName.text = data.productName
            tvProductQty.text = data.qty.toString()

            var productAmount: Long = 0
            if (data.discountPercentage != null) {
                val discount = data.price?.div(100)?.times(data.discountPercentage!!)
                val productFinalPrice = data.price?.minus(discount ?: 0) ?: 0
                productAmount = productFinalPrice.times(data.qty ?: 0)
            } else productAmount = data.price?.times(data.qty ?: 0) ?: 0
            tvTotalProductPrice.text = productAmount.toRupiahString()
        }

    }

    companion object {

    }
}