package com.naumov.appgithub.data

import android.os.Looper
import android.os.Handler
import com.naumov.appgithub.domain.entities.UserEntity
import com.naumov.appgithub.domain.repos.UsersRepo

private const val DATA_LOADING_FAKE_DELAY = 3_000L

class FakeUserRepoImpl : UsersRepo {

    private val data: List<UserEntity> = listOf(
        UserEntity("mojombo", 1, "https://avatars.githubusercontent.com/u/1?v=4"),
        UserEntity("defunkt", 2, "https://avatars.githubusercontent.com/u/2?v=4"),
        UserEntity("pjhyett", 3, "https://avatars.githubusercontent.com/u/3?v=4")
    )

    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed({ onSuccess(data) }, DATA_LOADING_FAKE_DELAY)
    }
}