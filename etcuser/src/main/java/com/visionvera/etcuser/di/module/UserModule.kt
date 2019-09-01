package com.visionvera.etcuser.di.module

import com.visionvera.etcuser.model.UserModel
import com.visionvera.etcuser.model.impl.UserModelImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun providerUserModel():UserModel{
        return UserModelImpl()
    }
}