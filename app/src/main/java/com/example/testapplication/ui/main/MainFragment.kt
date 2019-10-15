package com.example.testapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.R
import com.example.testapplication.data.DataRepository
import com.example.testapplication.databinding.MainFragmentBinding
import com.example.testapplication.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment() : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val binding: MainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        val viewModel:MainViewModel by viewModels {viewModelFactory}
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = MainAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(context)
        viewModel.dataList.observe(this, Observer(adapter::submitList))

        return binding.root
    }


    companion object {

        fun newInstance(): MainFragment {
            return MainFragment();
        }
    }
}
