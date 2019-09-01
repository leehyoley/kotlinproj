package com.visionvera.etcuser.model.impl

import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.etcuser.bean.UserBean
import com.visionvera.etcuser.model.UserApi
import com.visionvera.etcuser.model.UserModel
import com.visionvera.md.base.data.net.RetrofitFactory
import rx.Observable

class UserModelImpl :UserModel {
    override fun login(phone: String, password: String): Observable<LoginBean> {
        return RetrofitFactory.instance.create(UserApi::class.java).login(phone,password)
    }

    override fun getUserinfo(id: String): Observable<UserBean> {
        return RetrofitFactory.instance.create(UserApi::class.java).getUserinfo(id)
    }
}