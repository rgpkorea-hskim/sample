package com.dhk.dhksample.presentation.viewmodel

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.dhk.dhksample.base.BaseViewModel
import com.dhk.dhksample.presentation.model.UserModel
import com.dhk.dhksample.util.loadImage

class UserItemViewModel(internal val glideManger: RequestManager, val userModel: UserModel): BaseViewModel<Parcelable>() {

    override val tag: String
        get() = "UserItemViewModel"
}

@BindingAdapter("loadImage")
fun loadShopReviewImage(imageView: ImageView?,
                        viewModel: UserItemViewModel?) {
    imageView.loadImage(viewModel?.glideManger, viewModel?.userModel?.thumbNail)
}

