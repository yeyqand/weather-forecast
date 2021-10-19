package com.yeyq.weather.core.di

import android.app.Application
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.yeyq.weather.R
import com.yeyq.weather.core.exception.ErrorMapper
import com.yeyq.weather.core.exception.ErrorMapperImpl
import com.yeyq.weather.core.exception.ErrorWrapper
import com.yeyq.weather.core.exception.ErrorWrapperImpl
import com.yeyq.weather.core.navigation.FragmentNavigator
import com.yeyq.weather.core.navigation.FragmentNavigatorImpl
import com.yeyq.weather.core.provider.ActivityProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {
    @Binds
    abstract fun bindErrorWrapperImpl(errorWrapper: ErrorWrapperImpl):
            ErrorWrapper

    @Binds
    abstract fun bindErrorMapperImpl(errorMapper: ErrorMapperImpl):
            ErrorMapper

    companion object {
        @Provides
        @Singleton
        fun provideActivityProvider(application: Application) =
            ActivityProvider(application)

        @Provides
        fun provideNavOptions() =
            navOptions {
                anim { enter = R.anim.nav_default_enter_anim }
                anim { exit = R.anim.nav_default_exit_anim }
                anim { popEnter = R.anim.nav_default_pop_enter_anim }
                anim { popExit = R.anim.nav_default_pop_exit_anim }
            }

        @Provides
        fun provideFragmentNavigator(
            activityProvider: ActivityProvider,
            defaultNavOptions: NavOptions
        ): FragmentNavigator =
            FragmentNavigatorImpl(
                activityProvider,
                R.id.nav_host_fragment,
                defaultNavOptions
            )
    }
}