package com.dhk.dhksample.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dhk.dhksample.R
import com.dhk.dhksample.base.BaseFragment
import com.dhk.dhksample.databinding.FragmentMainBinding
import com.dhk.dhksample.presentation.viewmodel.MainFragmentViewModel

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel by lazy {
        createViewModel(MainFragmentViewModel())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}