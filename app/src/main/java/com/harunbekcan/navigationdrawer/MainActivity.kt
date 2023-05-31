package com.harunbekcan.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.harunbekcan.navigationdrawer.base.BaseActivity
import com.harunbekcan.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var actionDrawerToggle : ActionBarDrawerToggle

    override fun prepareView(savedInstanceState: Bundle?) {
        setDrawerToggle()
    }

    private fun setDrawerToggle() {
        binding.apply {
            actionDrawerToggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(actionDrawerToggle)
            actionDrawerToggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}