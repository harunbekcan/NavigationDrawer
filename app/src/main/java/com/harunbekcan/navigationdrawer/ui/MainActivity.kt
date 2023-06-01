package com.harunbekcan.navigationdrawer.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.harunbekcan.navigationdrawer.R
import com.harunbekcan.navigationdrawer.base.BaseActivity
import com.harunbekcan.navigationdrawer.databinding.ActivityMainBinding
import com.harunbekcan.navigationdrawer.databinding.NavigationHeaderBinding
import com.harunbekcan.navigationdrawer.utils.showToastMessage

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var actionDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationHeaderBinding: NavigationHeaderBinding

    override fun prepareView(savedInstanceState: Bundle?) {
        navigationHeaderBinding = NavigationHeaderBinding.bind(binding.navigationView.getHeaderView(0))
        setDrawerToggle()
        navHeaderLayoutMenuItemClicked()
    }

    private fun setDrawerToggle() {
        binding.apply {
            actionDrawerToggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(actionDrawerToggle)
            actionDrawerToggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun navHeaderLayoutMenuItemClicked() {
        navigationHeaderBinding.navHeaderMenu.apply {
            cameraContainer.setOnClickListener {
                showToastMessage(message = "Clicked Camera")
            }

            galleryContainer.setOnClickListener {
                showToastMessage(message = "Clicked Gallery")
            }

            shareContainer.setOnClickListener {
                showToastMessage(message = "Clicked Share")
            }

            slideShowContainer.setOnClickListener {
                showToastMessage(message = "Clicked SlideShow")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}