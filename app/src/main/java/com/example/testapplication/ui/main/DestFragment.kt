package com.example.testapplication.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import com.example.testapplication.R
import com.example.testapplication.databinding.DestFragmentBinding
import com.example.testapplication.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DestFragment : Fragment() {

    companion object {
        fun newInstance() = DestFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: DestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val binding:DestFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.dest_fragment, container, false)
        val viewModel: DestViewModel by viewModels { viewModelFactory }

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        arguments?.let {
            val value = DestFragmentArgs.fromBundle(it).lastNumber
            viewModel.number.value = value
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}
