package com.naumov.appgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naumov.appgithub.R
import com.naumov.appgithub.databinding.ActivityMainBinding
import com.naumov.appgithub.ui.users.RecyclerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecyclerFragment.newInstance())
                .commitNow()
        }
    }
}