package com.yeyq.weather.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyq.weather.core.adapter.BindableAdapter
import com.yeyq.weather.core.base.UiState

object BindingAdapters {
    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(animation: com.airbnb.lottie.LottieAnimationView, uiState: UiState) {
        animation.isVisible = uiState == UiState.Pending
    }

    @BindingAdapter("app:showOnIdleState")
    @JvmStatic
    fun showOnIdleState(textView: TextView, uiState: UiState) {
        textView.isVisible = uiState == UiState.Idle
    }

    @BindingAdapter("app:showOnErrorState")
    @JvmStatic
    fun showOnErrorState(view: View, uiState: UiState) {
        view.isVisible = uiState == UiState.Error
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)
    }
}