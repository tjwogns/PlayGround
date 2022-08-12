package com.example.playground.content.navigation

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityNavigationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : BaseActivity<ActivityNavigationBinding, NavigationViewModel>(
    R.layout.activity_navigation
) {

    private lateinit var appBarConfiguration : AppBarConfiguration


    override val viewModel: NavigationViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
//        val navController = binding.fcvNavigation.findNavController() // onCreate에서 가져올수 없음.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_navigation) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }

            Toast.makeText(
                this@NavigationActivity, "Navigated to $dest",
                Toast.LENGTH_SHORT
            ).show()
            Log.d("NavigationActivity", "Navigated to $dest")
        }
        setListener()

    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

//        val navController = binding.fcvNavigation.findNavController()
//        appBarConfiguration = AppBarConfiguration(navController.graph)


        println("!!! DEBUG !!! onPostCreate")
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            val dest: String = try {
//                resources.getResourceName(destination.id)
//            } catch (e: Resources.NotFoundException) {
//                destination.id.toString()
//            }
//
//            Toast.makeText(
//                this@NavigationActivity, "Navigated to $dest",
//                Toast.LENGTH_SHORT
//            ).show()
//            Log.d("NavigationActivity", "Navigated to $dest")
//        }
    }

    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
    }


    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {

    }

    companion object {
    }
}