package com.visionvera.etcuser.ui.activity

import android.os.Bundle
import com.visionvera.etcuser.R
import com.visionvera.etcuser.di.DaggerUserComponent
import com.visionvera.etcuser.di.UserModule
import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.etcuser.presenter.LoginPresenter
import com.visionvera.etcuser.presenter.view.LoginView
import com.visionvera.md.base.ui.activity.BaseMvpActivity
import org.jetbrains.anko.toast

class LoginActivity:BaseMvpActivity<LoginPresenter>(),LoginView{

    override fun onLogin(loginBean: LoginBean) {
        toast(loginBean.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter.login("1","2")

    }


    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
    }
}
