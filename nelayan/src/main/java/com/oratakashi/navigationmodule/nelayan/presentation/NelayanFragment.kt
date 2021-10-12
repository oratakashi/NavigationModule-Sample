package com.oratakashi.navigationmodule.nelayan.presentation

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oratakashi.navigationmodule.nelayan.R
import com.oratakashi.navigationmodule.nelayan.databinding.FragmentNelayanBinding
import com.oratakashi.navigationmodule.nelayan.utils.enum.BroadcastEnum
import com.oratakashi.navigationmodule.nelayan.utils.enum.ModuleEnum
import com.oratakashi.viewbinding.core.binding.fragment.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick


class NelayanFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnLogout.onClick { requireContext().sendBroadcast(Intent(BroadcastEnum.LOGOUT.value).apply {
                putExtra(ModuleEnum.Nelayan.name, ModuleEnum.Nelayan.value)
            }) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    private val binding: FragmentNelayanBinding by viewBinding()
}