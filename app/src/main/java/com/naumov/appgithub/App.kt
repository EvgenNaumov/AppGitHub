package com.naumov.appgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment

class App:Application() {
    val userRepo: UsersRepo by lazy { FakeUserRepoImpl() }

    override fun onCreate() {
        super.onCreate()
    }
}

val Context.app: App get() = applicationContext as App
val Fragment.app: App get() = requireContext().applicationContext as App