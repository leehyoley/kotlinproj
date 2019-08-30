package com.visionvera.mdbase.di.component

import android.app.Activity
import android.content.Context
import com.visionvera.mdbase.di.ActivityScope
import com.visionvera.mdbase.di.module.ActivityModule
import com.visionvera.mdbase.di.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/*
    Activity级别Component
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity():Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
