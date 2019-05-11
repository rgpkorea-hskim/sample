package com.dhk.dhksample.presentation.viewmodel

import android.os.Parcelable
import com.dhk.dhksample.base.BaseViewModel
import com.dhk.dhksample.domain.usecase.UserUseCase
import com.xwray.groupie.Section

class SearchFragmentViewModel(private val searchKeyWord: String,
                              private val section: Section,
                              private val userUseCase: UserUseCase): BaseViewModel<Parcelable>() {

    override val tag: String
        get() = "SearchFragmentViewModel"
}