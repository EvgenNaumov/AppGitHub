package com.naumov.appgithub.domain.repos

import com.naumov.appgithub.domain.entities.UserEntity

interface UsersRepo {
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
}