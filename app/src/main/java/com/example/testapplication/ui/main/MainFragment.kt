package com.example.testapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.R
import com.example.testapplication.databinding.MainFragmentBinding
import com.example.testapplication.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val adapter = MainAdapter()
        viewModel.dataList.observe(this, Observer(adapter::submitList))

        return DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false).apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = this@MainFragment
            direction = MainFragmentDirections.Companion
            list.adapter = adapter
            list.layoutManager = LinearLayoutManager(context)
        }.root
    }
}
