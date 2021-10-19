package com.yeyq.weather.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel, S : ViewDataBinding>(
    private val viewModelId: Int,
    @LayoutRes layoutRes: Int
) : Fragment(layoutRes) {

    abstract val viewModel: T
    var binding: S? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(viewModelId, viewModel)
            initViews(it)
        }
        initObservers()
        bindViewModelToLifecycle()
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    open fun initViews(binding: S) {}

    open fun initObservers() {
        observeMessage()
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) { message ->
            showToast(message)
        }
    }

    open fun onIdleState() {}

    open fun onPendingState() {}

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}