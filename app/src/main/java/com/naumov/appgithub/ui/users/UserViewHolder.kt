package com.naumov.appgithub.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.naumov.appgithub.R
import com.naumov.appgithub.domain.entities.UserEntity
import com.naumov.appgithub.databinding.ItemFragmentBinding

class UserViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_fragment,parent,false)
) {
private val binding = ItemFragmentBinding.bind(itemView)
    fun bind(userEntity: UserEntity){
        binding.avatarImageView.load(userEntity.avatarUrl)
        binding.loginTextView.text = userEntity.login
        binding.uidTextView.text = userEntity.id.toString()
    }

}