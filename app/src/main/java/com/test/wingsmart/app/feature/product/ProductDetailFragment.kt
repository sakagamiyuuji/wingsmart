package com.test.wingsmart.app.feature.product

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.wingsmart.app.databinding.FragmentProductBinding
import com.test.wingsmart.app.databinding.FragmentProductDetailBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.core.base.BaseFragment
import com.test.wingsmart.core.util.CurrencyHelper.toRupiahString
import com.test.wingsmart.core.util.showToast
import com.test.wingsmart.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>(){
    private val product by lazy { activity?.intent?.getParcelableExtra<Product>(KEY_PRODUCT) }

    override fun setBinding(layoutInflater: LayoutInflater): FragmentProductDetailBinding {
        return FragmentProductDetailBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViewModel()
        with(binding) {
            tvProductName.text = product?.productName
            tvDimension.text = product?.dimension
            tvPrice.text = product?.price?.toRupiahString()
            tvUnit.text = product?.unit
            btnBuy.setOnClickListener {
                val resultIntent = Intent()
                resultIntent.putExtra(KEY_PRODUCT_DETAIL_RESULT, product)
                activity?.setResult(Activity.RESULT_OK, resultIntent)
                activity?.finish()
            }
        }

    }

    private fun configureViewModel() {

    }

    companion object {
        const val KEY_PRODUCT = "KEY_PRODUCT"
        const val KEY_PRODUCT_DETAIL_RESULT = "KEY_PRODUCT_DETAIL_RESULT"
        const val KEY_PRODUCT_DETAIL_REQUEST_CODE = 1001
        fun newInstance(): ProductDetailFragment = ProductDetailFragment()
    }


}