package com.test.wingsmart.app.feature.transaction

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.test.wingsmart.app.databinding.ActivityHomeBinding
import com.test.wingsmart.app.databinding.ActivityProductDetailBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.app.feature.product.ProductFragment
import com.test.wingsmart.core.base.BaseActivity
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionActivity: BaseActivity<ActivityProductDetailBinding>() {
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
                TransactionFragment.newInstance()
            )
            .commit()
    }

    companion object {
        private const val KEY_TRANSACTION = "KEY_TRANSACTION"
        fun launchIntent(context: Context, transaction: Transaction) {
            val intent = Intent(context, TransactionActivity::class.java)
            intent.putExtra(KEY_TRANSACTION, transaction)
            context.startActivity(intent)
        }
    }
}