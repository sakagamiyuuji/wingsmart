package com.test.wingsmart.app.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.test.wingsmart.app.databinding.ActivityHomeBinding
import com.test.wingsmart.app.feature.login.LoginFragment
import com.test.wingsmart.app.feature.product.ProductFragment
import com.test.wingsmart.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: BaseActivity<ActivityHomeBinding>() {
    override fun setBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.flContainer.id,
                ProductFragment.newInstance()
            )
            .commit()
    }

    companion object {
        fun launchIntent(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}