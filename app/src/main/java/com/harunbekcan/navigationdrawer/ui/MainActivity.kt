package com.harunbekcan.navigationdrawer.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.harunbekcan.navigationdrawer.R
import com.harunbekcan.navigationdrawer.base.BaseActivity
import com.harunbekcan.navigationdrawer.databinding.ActivityMainBinding
import com.harunbekcan.navigationdrawer.databinding.NavigationHeaderBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var actionDrawerToggle : ActionBarDrawerToggle
    private lateinit var navigationHeaderBinding: NavigationHeaderBinding

    override fun prepareView(savedInstanceState: Bundle?) {
        navigationHeaderBinding = NavigationHeaderBinding.bind(binding.navigationView.getHeaderView(0))
        setDrawerToggle()
        navHeaderLayoutMenuItemClicked()
    }

    private fun setDrawerToggle() {
        binding.apply {
            actionDrawerToggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(actionDrawerToggle)
            actionDrawerToggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun navHeaderLayoutMenuItemClicked(){
       navigationHeaderBinding.navHeaderMenu.apply {
            cameraContainer.setOnClickListener {
                    Log.d("HARUNHARUN","Clicked On Camera")
                }

            galleryContainer.setOnClickListener {
                Log.d("HARUNHARUN","Clicked On Gallery")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}