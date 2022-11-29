package com.test.wingsmart.app.feature.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.wingsmart.app.databinding.FragmentProductBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.core.base.BaseFragment
import com.test.wingsmart.core.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>(){

    private val viewModel: ProductViewModel by viewModels()

    private val adapter by lazy { ProductAdapter() }

    override fun setBinding(layoutInflater: LayoutInflater): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        configureViewModel()
        viewModel.getProductData()
    }

    private fun initAdapter() {
        binding.rvProduct.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.onClick = {
            ProductDetailActivity.launchIntent(requireContext(), it)
        }
        binding.rvProduct.adapter = adapter
    }

    private fun configureViewModel() {
        viewModel.productListLiveData.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                adapter.addItems(it)
            } else requireContext().showToast("Data kosong")
        }
    }

    companion object {
        fun newInstance(): ProductFragment = ProductFragment()
    }


}