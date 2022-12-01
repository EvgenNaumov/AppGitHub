package com.naumov.appgithub.ui.users

import com.naumov.appgithub.domain.entities.UserEntity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val data = mutableListOf<UserEntity>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = getItem(position).id


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getItem(pos: Int): UserEntity = data[pos]

    fun setData(users: List<UserEntity>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }
}