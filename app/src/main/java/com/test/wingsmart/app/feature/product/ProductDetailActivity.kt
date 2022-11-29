package com.test.wingsmart.app.feature.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.test.wingsmart.app.databinding.ActivityHomeBinding
import com.test.wingsmart.app.databinding.ActivityProductDetailBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.app.feature.product.ProductFragment
import com.test.wingsmart.core.base.BaseActivity
import com.test.wingsmart.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailActivity: BaseActivity<ActivityProductDetailBinding>() {
    override fun setBinding(layoutInflater: LayoutInflater): ActivityProductDetailBinding {
        return ActivityProductDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.flContainer.id,
                ProductDetailFragment.newInstance()
            )
            .commit()
    }

    companion object {
        const val KEY_PRODUCT = "KEY_PRODUCT"
        fun launchIntent(context: Context, product: Product) {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(KEY_PRODUCT, product)
            context.startActivity(intent)
        }

        fun launchIntentForResultFromFragment(
            fragment: Fragment,
            requestCode: Int,
            product: Product
        ) {
            val intent = Intent(fragment.requireContext(), ProductDetailActivity::class.java)
            intent.putExtra(KEY_PRODUCT, product)
            fragment.startActivityForResult(intent, requestCode)
        }
    }
}