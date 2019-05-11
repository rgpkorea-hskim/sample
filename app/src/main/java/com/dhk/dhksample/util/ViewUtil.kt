package com.dhk.dhksample.util

object ViewUtil {

    private var preClickTime = 0L

    fun checkDoubleClick(onClick: () -> Unit) {
        val currentClickTime = System.currentTimeMillis()
        if(currentClickTime - preClickTime > 500) {
            preClickTime = currentClickTime
            onClick()
        }
    }
}