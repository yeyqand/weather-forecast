package com.yeyq.weather.core.navigation

import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.yeyq.weather.core.provider.ActivityProvider
import javax.inject.Inject

class FragmentNavigatorImpl @Inject constructor(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostController: Int,
    private val defaultNavOptions: NavOptions
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostController)
        ?.findNavController()

    override fun <T> navigateTo(
        destinationId: Int,
        param: Pair<String, T>?,
        fragmentTransition: FragmentTransition?
    ) {
        val bundle = param?.let { bundleOf(it) }
        val navOptions = fragmentTransition?.let {
            navOptions {
                anim { enter = it.enterAnim }
                anim { exit = it.exitAnim }
                anim { popEnter = it.popEnterAnim }
                anim { popExit = it.popExitAnim }
            }
        } ?: defaultNavOptions

        getNavController()?.navigate(destinationId, bundle, navOptions)
    }

    override fun navigateTo(
        destinationId: Int,
        fragmentTransition: FragmentTransition?
    ) {
        navigateTo<Unit>(destinationId, null, fragmentTransition)
    }

    override fun goBack(destinationId: Int?, inclusive: Boolean) {
        if (destinationId == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationId, inclusive)
    }
}