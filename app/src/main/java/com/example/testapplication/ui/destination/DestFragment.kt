package com.example.testapplication.ui.destination

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
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel: DestViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)

        arguments?.let {
            viewModel.message.value = DestFragmentArgs.fromBundle(it).lastMessage
        }

        return DataBindingUtil.inflate<DestFragmentBinding>(inflater, R.layout.dest_fragment, container, false).apply {
            lifecycleOwner = this@DestFragment
            viewModel = this@DestFragment.viewModel
        }.root
    }

}
