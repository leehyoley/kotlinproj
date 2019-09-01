package com.visionvera.etcuser.presenter

import com.trello.rxlifecycle.LifecycleProvider
import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.etcuser.model.UserModel
import com.visionvera.etcuser.presenter.view.LoginView
import com.visionvera.md.base.data.protocol.BaseResp
import com.visionvera.md.base.ext.excute
import com.visionvera.md.base.presenter.BasePresenter
import com.visionvera.md.base.presenter.view.BaseView
import com.visionvera.md.base.rx.BaseSubscriber
import javax.inject.Inject

class LoginPresenter @Inject constructor() :BasePresenter<LoginView>(){
    @Inject
    lateinit var userModel: UserModel

    fun login(phone:String,password:String){
        userModel.login(phone,password).excute(LoginSubscriber(mView),lifecycleProvider)
    }

    fun showHello(){
        mView.onLogin(LoginBean("", ""))
    }

    class LoginSubscriber(baseView: BaseView) : BaseSubscriber<LoginBean>(baseView){
        override fun onNext(t: LoginBean) {
        }
    }
}