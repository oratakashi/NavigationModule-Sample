package com.oratakashi.navigationmodule.petambak.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oratakashi.navigationmodule.petambak.R
import com.oratakashi.navigationmodule.petambak.databinding.FragmentPetambakBinding
import com.oratakashi.navigationmodule.petambak.utils.enum.BroadcastEnum
import com.oratakashi.navigationmodule.petambak.utils.enum.ModuleEnum
import com.oratakashi.viewbinding.core.binding.fragment.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick


class PetambakFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnLogout.onClick {
                requireContext().sendBroadcast(Intent(BroadcastEnum.LOGOUT.value).apply {
                    putExtra(ModuleEnum.Petambak.name, ModuleEnum.Petambak.value)
                })
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

    private val binding: FragmentPetambakBinding by viewBinding()
}