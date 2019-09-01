package com.visionvera.etcuser.model

import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.etcuser.bean.UserBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    @FormUrlEncoded
    @POST("hello")
    fun login(@Field("phone") phone:String,@Field("password") password:String):Observable<LoginBean>

    @FormUrlEncoded
    @POST("hello")
    fun getUserinfo(@Field("id") id:String):Observable<UserBean>
}