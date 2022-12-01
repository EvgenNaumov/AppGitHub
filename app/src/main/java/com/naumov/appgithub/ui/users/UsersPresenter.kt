package com.naumov.appgithub.ui.users

import com.naumov.appgithub.domain.repos.UsersRepo

class UsersPresenter(private val userRepo: UsersRepo) : UsersContract.Presenter {

    private var view: UsersContract.View? = null

    override fun attach(_view: UsersContract.View) {
        this.view = _view
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgress(true)
        userRepo.getUsers(

            onSuccess = {
                view?.showProgress(false)
                view?.showUsers(it)
            },
            onError = {
                view?.showProgress(false)
                view?.showError(it)
            }
        )
    }
}