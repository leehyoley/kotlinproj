package com.visionvera.etcuser.di.component

import com.visionvera.etcuser.di.module.UserModule
import com.visionvera.etcuser.ui.activity.LoginActivity
import com.visionvera.md.base.di.PerComponentScope
import com.visionvera.md.base.di.component.ActivityComponent
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class],modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: LoginActivity)
}