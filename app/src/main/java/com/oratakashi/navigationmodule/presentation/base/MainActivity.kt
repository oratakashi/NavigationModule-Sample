package com.oratakashi.navigationmodule.presentation.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.oratakashi.navigationmodule.R
import com.oratakashi.navigationmodule.databinding.ActivityMainBinding
import com.oratakashi.navigationmodule.nelayan.presentation.NelayanFragmentDirections as nelayanDir
import com.oratakashi.navigationmodule.petambak.presentation.PetambakFragmentDirections as petambakDir
import com.oratakashi.navigationmodule.utils.enum.BroadcastEnum
import com.oratakashi.navigationmodule.utils.enum.ModuleEnum
import com.oratakashi.viewbinding.core.binding.activity.viewBinding

class MainActivity : AppCompatActivity() {

    private val logOutReceiver: BroadcastReceiver by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if(intent?.getStringExtra(ModuleEnum.Nelayan.name) != null){
                    nav?.navigate(nelayanDir.actionNelayanFragmentToAuthFragment())
                }else{
                    nav?.navigate(petambakDir.actionPetambakFragmentToAuthFragment())
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding){

        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(logOutReceiver, IntentFilter(BroadcastEnum.LOGOUT.value))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(logOutReceiver)
    }

    private val binding: ActivityMainBinding by viewBinding()
    private val nav: NavController? by lazy { findNavController(R.id.nav_host_fragment_main) }
}