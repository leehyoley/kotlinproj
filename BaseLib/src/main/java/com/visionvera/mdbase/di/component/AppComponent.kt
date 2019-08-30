package com.visionvera.mdbase.di.component

import android.content.Context
import com.visionvera.mdbase.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/*
    Application级别Component
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context
}
