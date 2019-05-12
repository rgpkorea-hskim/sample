package com.dhk.dhksample.presentation.adapter

import com.dhk.dhksample.R
import com.dhk.dhksample.databinding.ViewUserItemBinding
import com.dhk.dhksample.presentation.viewmodel.UserItemViewModel
import com.xwray.groupie.databinding.BindableItem

class UserItem(val userItemViewModel: UserItemViewModel) : BindableItem<ViewUserItemBinding>() {

    override fun getLayout() = R.layout.view_user_item

    override fun bind(viewBinding: ViewUserItemBinding, position: Int) {
        viewBinding.viewModel = userItemViewModel
    }
}