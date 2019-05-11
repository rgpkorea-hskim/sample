package com.dhk.dhksample.base

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {

    private var savedState: Bundle? = null

    protected val disposables by lazy {
        CompositeDisposable()
    }

    private val viewModelMap by lazy {
        mutableMapOf<String, BaseViewModel<out Parcelable>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedState = savedInstanceState
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModelMap.forEach {
            outState.putParcelable(it.key, it.value.recoveryRepo)
        }
    }

    override fun onDetach() {
        disposables.clear()
        viewModelMap.clear()
        super.onDetach()
    }

    protected fun <VIEW_MODEL : BaseViewModel<out Parcelable>> createViewModel(viewModel: VIEW_MODEL, customKey: String = ""): VIEW_MODEL {
        return viewModel.apply {
            val className = if(customKey.isBlank()) tag else customKey
            onStateRestored(savedState, className)
            lifecycle.addObserver(this)
            viewModelMap[className] = this
        }
    }
}