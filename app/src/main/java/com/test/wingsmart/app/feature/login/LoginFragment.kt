package com.test.wingsmart.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.test.wingsmart.app.databinding.FragmentLoginBinding
import com.test.wingsmart.app.feature.HomeActivity
import com.test.wingsmart.core.base.BaseFragment
import com.test.wingsmart.core.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun setBinding(layoutInflater: LayoutInflater): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUiCallback()
        configureViewModel()
    }

    private fun initUiCallback() {
        with(binding) {
            btnLogin.setOnClickListener {
//                if (etUsername.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
//                    requireContext().showToast("Mohon masukan username/password\n" +
//                            "Username: admin\n" +
//                            "Password: 1234")
//                }
//                if (etUsername.text.toString() == "admin" && etPassword.text.toString() == "1234") {
//                    HomeActivity.launchIntent(requireContext())
//                } else {
//                    requireContext().showToast("Username/Password Salah\n" +
//                            "Username: admin\n" +
//                            "Password: 1234")
//                }
                viewModel.login(
                    etUsername.text.toString(),
                    etPassword.text.toString()
                )
            }
        }
    }

    fun configureViewModel() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            if (it!=null) {
                if (it == true) {
                    Toast.makeText(requireContext(), "Success Login", Toast.LENGTH_SHORT).show()
                    HomeActivity.launchIntent(requireContext())
                }
                else Toast.makeText(requireContext(), "Username/Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }
}