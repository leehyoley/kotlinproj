package com.visionvera.etcuser.di

import com.visionvera.etcuser.ui.activity.LoginActivity
import com.visionvera.md.base.di.PerComponentScope
import com.visionvera.md.base.di.component.ActivityComponent
import com.visionvera.md.base.di.component.AppComponent
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class],modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: LoginActivity)
}