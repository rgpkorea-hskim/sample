package com.dhk.dhksample.presentation.viewmodel

import android.os.Parcelable
import android.util.Log
import androidx.databinding.Bindable
import com.dhk.dhksample.BR
import com.dhk.dhksample.base.BaseViewModel
import kotlinx.android.parcel.Parcelize

class MainFragmentViewModel : BaseViewModel<MainFragmentRecoveryState>() {

    override val tag: String
        get() = "MainFragmentViewModel"

    override var recoveryRepo: MainFragmentRecoveryState? = MainFragmentRecoveryState("")

    var searchWord: String
        @Bindable
        get() = recoveryRepo?.searchKeyWord ?: ""
        set(value) {
            recoveryRepo?.searchKeyWord = value
            notifyPropertyChanged(BR.searchWord)
        }

    fun search() {
        Log.d("wowow", "searchKeyWord : $searchWord")
    }
}

@Parcelize
data class MainFragmentRecoveryState(var searchKeyWord: String) : Parcelable