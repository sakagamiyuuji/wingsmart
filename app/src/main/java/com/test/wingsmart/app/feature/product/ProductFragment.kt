package com.test.wingsmart.app.feature.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.wingsmart.app.databinding.FragmentProductBinding
import com.test.wingsmart.app.feature.transaction.TransactionActivity
import com.test.wingsmart.app.feature.transaction.TransactionViewModel
import com.test.wingsmart.core.base.BaseFragment
import com.test.wingsmart.core.util.showToast
import com.test.wingsmart.domain.model.Transaction
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>() {

    private val viewModel: ProductViewModel by viewModels()
    private val transactionViewModel: TransactionViewModel by viewModels()

    private val adapter by lazy { ProductAdapter() }

    private var latestTransactionNumber = "1"
    var currentActiveTransaction: Transaction? = null

    override fun setBinding(layoutInflater: LayoutInflater): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initUiCallback()
        configureViewModel()
        viewModel.getProductData()
        transactionViewModel.getAllTransaction()
    }

    private fun initUiCallback() {
        binding.btnCheckout.setOnClickListener {
            if (currentActiveTransaction!=null) {
                transactionViewModel.updateTransaction(currentActiveTransaction!!)
                TransactionActivity.launchIntent(requireContext(), currentActiveTransaction!!)
            } else {
                requireContext().showToast("Belum ada product yang di tambahkan")
            }
        }
    }

    private fun initAdapter() {
        binding.rvProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.onClick = {
            ProductDetailActivity.launchIntent(requireContext(), it)
        }
        adapter.onBuy = {
            if (currentActiveTransaction?.documentCode.isNullOrEmpty()) {
                currentActiveTransaction = Transaction(
                    documentCode = "TRX",
                    documentNumber = latestTransactionNumber,
                    products = listOf(it.apply {
                        qty = 1
                    }),
                    date = getFormattedDateToday()
                )
            } else {
                val latestProduct = currentActiveTransaction?.products
                val existProduct =
                    latestProduct?.firstOrNull { prod -> it.productCode == prod.productCode }
                if (existProduct != null) {
                    existProduct.qty = existProduct.qty?.plus(1)
                } else {
                    val temp = latestProduct?.toMutableList()
                    temp?.add(it.apply {
                        qty = 1
                    })
                    currentActiveTransaction?.products = temp
                }
            }
            requireContext().showToast("Product Added")
        }
        binding.rvProduct.adapter = adapter
    }

    private fun configureViewModel() {
        viewModel.productListLiveData.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                adapter.addItems(it)
            } else requireContext().showToast("Data kosong")
        }

//        transactionViewModel.pendingTransactionLiveData.observe(viewLifecycleOwner) {
//            if (it != null) {
//                currentActiveTransaction = it
//            }
//        }

        transactionViewModel.allTransactionLiveData.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                val lastNumber = it[it.lastIndex].documentNumber?.toIntOrNull()
                if (it.isNotEmpty()) {
                    currentActiveTransaction = it.firstOrNull { data -> data.isSuccess == false }
                    latestTransactionNumber = lastNumber.toString()
                } else {
                    if (lastNumber != null) {
                        latestTransactionNumber = (lastNumber + 1).toString()
                    }
                }
            }
        }
    }

    fun getFormattedDateToday(): String {
        val currentTime = Calendar.getInstance().time
        val currentDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = currentDateFormat.format(currentTime)

        return formattedDate
    }

    companion object {
        fun newInstance(): ProductFragment = ProductFragment()
    }

}

