package com.visionvera.mdbase.presenter

import android.content.Context
import com.visionvera.mdbase.presenter.view.BaseView
import com.visionvera.mdbase.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/*
    MVP中P层 基类
 */
open class BasePresenter<T:BaseView>{

    lateinit var mView:T

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>


    @Inject
    lateinit var context:Context

    /*
        检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}
