package com.example.weather.view.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.weather.R
import com.example.weather.view.Alert.AlertActivity
import com.example.weather.view.Favorite.FavouriteActivity
import com.example.weather.view.Settings.SettingActivity
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        navigationView.bringToFront()
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout!!.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.item_home)

    }
    // drawer
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )
            R.id.item_setting -> startActivity(
                Intent(
                    this,
                    SettingActivity::class.java
                )
            )
            R.id.item_fav -> startActivity(
                Intent(
                    this,
                    FavouriteActivity::class.java
                )
            )
            R.id.item_alert -> startActivity(
                Intent(
                    this,
                    AlertActivity::class.java
                )
            )

        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true    }
}