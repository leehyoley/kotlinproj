package com.visionvera.etcuser.di

import com.visionvera.etcuser.model.UserModel
import com.visionvera.etcuser.model.impl.UserModelImpl
import com.visionvera.etcuser.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun providerUserModel():UserModel{
        return UserModelImpl()
    }
}