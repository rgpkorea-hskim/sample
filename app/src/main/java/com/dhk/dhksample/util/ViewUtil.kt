package com.dhk.dhksample.util

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

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

fun ImageView?.loadImage(manager: RequestManager?,
                         url: String?,
                         holderImage: Int = 0,
                         errorImage: Int = 0) {
    safeLet(this, manager, url) { view, glideManger, imageUrl ->
        if(imageUrl.isBlank()) {
            glideManger.clear(view)
        }else {
            glideManger.load(imageUrl)
                .apply(RequestOptions().apply {
                    if(holderImage > 0) {
                        placeholder(holderImage)
                    }

                    if(errorImage > 0) {
                        error(errorImage)
                    }
                })
                .into(view)
        }
    }
}
