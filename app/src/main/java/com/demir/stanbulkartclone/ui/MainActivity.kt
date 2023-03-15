package com.demir.stanbulkartclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.databinding.ActivityMainBinding
import com.demir.stanbulkartclone.util.SharedPref

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPref: SharedPref
    private var refreshTime= 1*60*1000*1000*1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.background=null
        sharedPref= SharedPref(this)
        binding.bottomNav.menu.getItem(2).isEnabled=false
        val nav=Navigation.findNavController(this,R.id.fragmentContainerView)
        binding.bottomNav.setupWithNavController(nav)
        nav.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.passwordFragment ->binding.bottomNav.visibility = View.GONE
                else -> binding.bottomNav.visibility = View.VISIBLE
            }
        }
        binding.bottomNav.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.kartlarimFragment->{if (sharedPref.getTime()==null){
                    nav.navigate(R.id.passwordFragment)
                }else if (System.nanoTime()- sharedPref.getTime()!! <refreshTime){
                    nav.navigate(R.id.kartlarimFragment)
                }else{
                    nav.navigate(R.id.passwordFragment)
                }
                return@setOnItemSelectedListener false
                }
                R.id.homeFragment->{nav.navigate(R.id.homeFragment)
                return@setOnItemSelectedListener false}
                R.id.bulFragment->{nav.navigate(R.id.bulFragment)
                return@setOnItemSelectedListener false}
                R.id.islemlerFragment->{nav.navigate(R.id.islemlerFragment)
                return@setOnItemSelectedListener false}

                else -> { return@setOnItemSelectedListener false}
            }
        }
    }
}