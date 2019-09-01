package com.visionvera.etcuser.presenter.view

import com.visionvera.etcuser.bean.LoginBean
import com.visionvera.md.base.presenter.view.BaseView

interface LoginView :BaseView {
    fun onLogin(loginBean: LoginBean)
}