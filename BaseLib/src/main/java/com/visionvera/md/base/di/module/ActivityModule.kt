package com.visionvera.md.base.di.module

import android.app.Activity
import com.visionvera.md.base.di.ActivityScope
import dagger.Module
import dagger.Provides

/*
    Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}
