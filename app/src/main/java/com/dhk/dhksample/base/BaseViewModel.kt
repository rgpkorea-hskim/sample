package com.dhk.dhksample.base

import android.os.Bundle
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<REPO : Parcelable> : BaseObservable(), LifecycleObserver, LifecycleOwner {

    abstract val tag : String

    open var recoveryRepo: REPO? = null

    protected val disposables by lazy {
        CompositeDisposable()
    }

    private val lifecycleRegistry: LifecycleRegistry by lazy {
        LifecycleRegistry(this)
    }

    internal fun onStateRestored(savedState: Bundle?, customKey: String) {
        savedState?.let {
            it.getParcelable<REPO>(customKey)?.let { repo ->
                recoveryRepo = repo
            }
        }
    }

    private var preClickTime : Long = 0

    protected fun checkDoubleClick(onClick: () -> Unit) {
        val currentClickTime = System.currentTimeMillis()
        if(currentClickTime - preClickTime > 500) {
            preClickTime = currentClickTime
            onClick()
        }
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onStateEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        lifecycleRegistry.handleLifecycleEvent(event)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        disposables.clear()
    }
}