package com.visionvera.etcuser.model

import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.etcuser.bean.UserBean
import rx.Observable
import rx.Observer

interface UserModel {
    fun login(phone:String,password:String): Observable<LoginBean>
    fun getUserinfo(id:String):Observable<UserBean>
}