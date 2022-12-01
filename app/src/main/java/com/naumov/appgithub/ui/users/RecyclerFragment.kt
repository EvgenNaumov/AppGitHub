package com.naumov.appgithub.ui.users

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
import com.naumov.appgithub.domain.entities.UserEntity
import com.naumov.appgithub.domain.repos.UsersRepo

class RecyclerFragment : Fragment(), UsersContract.View {

    private var _binding: RecyclerFragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter: UsersAdapter = UsersAdapter()
    private lateinit var presenter:UsersContract.Presenter

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
        presenter = UsersPresenter(app.userRepo)
        presenter.attach(this)
    }

    private fun initView() {

        binding.recyclerButton.setOnClickListener {
            presenter.onRefresh()
        }
        initRecycleeView()
        showProgress(false)

    }

    private fun initRecycleeView() {
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
        binding.recycler.adapter = adapter

    }

    override fun showUsers(it: List<UserEntity>) {
        adapter.setData(it)
    }

    override fun showProgress(isProcess: Boolean) {
        binding.progressBar.isVisible = isProcess
        binding.usersRecyclerView.isVisible = !isProcess
    }

    override fun showError(throwable: Throwable){
        Toast.makeText(this.context, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = RecyclerFragment()
    }
}