package com.naumov.appgithub.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.naumov.appgithub.*
import com.naumov.appgithub.databinding.RecyclerFragmentBinding

class RecyclerFragment : Fragment() {

    private var _binding: RecyclerFragmentBinding? = null
    private val binding get() = _binding!!
    private val userRepo: UsersRepo by lazy { requireContext().app.userRepo }

    private val adapter: UsersAdapter = UsersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecyclerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        initRecycleeView()
    }

    private fun initView() {
        showProgress(false)

        binding.recyclerButton.setOnClickListener {
            loadData()
        }
    }

    private fun loadData() {
        showProgress(true)
        userRepo.getUsers(

            onSuccess = {
                showProgress(false)
                onDataLoaded(it)
            },
            onError = {
                showProgress(false)
                onError(it)
            }
        )
    }

    private fun onDataLoaded(it: List<UserEntity>) {
        adapter.setData(it)
    }

    private fun initRecycleeView() {
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
        binding.recycler.adapter = adapter

    }

    private fun showProgress(isProcess: Boolean) {
        binding.progressBar.isVisible = isProcess
        binding.usersRecyclerView.isVisible = !isProcess
    }

    private fun onError(throwable: Throwable){
        Toast.makeText(this.context, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = RecyclerFragment()
    }
}