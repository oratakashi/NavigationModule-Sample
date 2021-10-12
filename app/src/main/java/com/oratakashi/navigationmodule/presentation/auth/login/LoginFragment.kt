package com.oratakashi.navigationmodule.presentation.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.oratakashi.navigationmodule.R
import com.oratakashi.navigationmodule.databinding.FragmentLoginBinding
import com.oratakashi.navigationmodule.presentation.auth.AuthFragmentDirections
import com.oratakashi.viewbinding.core.binding.fragment.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick


class LoginFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnRegister.onClick {
                auth?.navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
            btnNelayan.onClick {
                navigation?.navigate(AuthFragmentDirections.actionAuthFragmentToNelayanFragment())
            }
            btnPetambak.onClick {
                navigation?.navigate(AuthFragmentDirections.actionAuthFragmentToPetambakFragment())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    private val binding: FragmentLoginBinding by viewBinding()
    private val navigation: NavController? by lazy { activity?.findNavController(R.id.nav_host_fragment_main) }
    private val auth: NavController? by lazy { activity?.findNavController(R.id.nav_host_fragment_auth) }
}