package com.visionvera.md.base.di.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/*
    Rx生命周期管理能用Module
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun provideLifecycleProvider(): LifecycleProvider<*> {
        return this.lifecycleProvider
    }
}
