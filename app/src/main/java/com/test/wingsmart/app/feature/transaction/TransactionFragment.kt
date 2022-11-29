package com.test.wingsmart.app.feature.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.wingsmart.app.databinding.FragmentProductBinding
import com.test.wingsmart.app.databinding.FragmentProductDetailBinding
import com.test.wingsmart.app.databinding.FragmentTransactionBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.app.feature.product.ProductAdapter
import com.test.wingsmart.app.feature.product.ProductDetailActivity
import com.test.wingsmart.app.feature.product.ProductDetailFragment
import com.test.wingsmart.app.feature.product.ProductViewModel
import com.test.wingsmart.core.base.BaseFragment
import com.test.wingsmart.core.util.CurrencyHelper.toRupiahString
import com.test.wingsmart.core.util.showToast
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionFragment : BaseFragment<FragmentTransactionBinding>() {
    private val transaction by lazy { activity?.intent?.getParcelableExtra<Transaction>(KEY_TRANSACTION) }

    private val adapter by lazy { TransactionProductAdapter() }
    private val viewModel: TransactionViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentTransactionBinding {
        return FragmentTransactionBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        configureViewModel()

        with(binding) {
            var totalAmount: Long = 0
            transaction?.products?.forEach {
                val productAfterDiscount = it.price?.times((it.discountPercentage ?: 1))
                val productAmount = productAfterDiscount?.times(it.qty ?: -1) ?: 0
                totalAmount += productAmount
            }
            tvTransactionAmount.text = totalAmount.toRupiahString(true, withSuffix = true)
            btnConfirm.setOnClickListener {
                transaction?.total = totalAmount
                transaction?.isSuccess = true
                transaction?.let { trx -> viewModel.updateTransaction(trx) }
            }

        }

    }

    private fun configureViewModel() {

    }

    private fun initAdapter() {
        transaction?.products?.let { adapter.addItems(it) }
        binding.rvProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvProduct.adapter = adapter
    }

    companion object {
        const val KEY_TRANSACTION = "KEY_TRANSACTION"
        fun newInstance(): TransactionFragment = TransactionFragment()
    }


}