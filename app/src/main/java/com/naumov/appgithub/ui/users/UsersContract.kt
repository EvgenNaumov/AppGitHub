package com.naumov.appgithub.ui.users

import android.view.View
import com.naumov.appgithub.domain.entities.UserEntity

interface UsersContract {

    interface View {
        fun showUsers(users: List<UserEntity>)
        fun showError(throwable: Throwable)
        fun showProgress(isProcess: Boolean)
    }



    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun onRefresh()
    }
}