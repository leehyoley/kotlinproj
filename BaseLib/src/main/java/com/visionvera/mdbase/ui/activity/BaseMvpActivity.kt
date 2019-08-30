package com.visionvera.mdbase.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.visionvera.mdbase.common.BaseApplication
import com.visionvera.mdbase.di.component.ActivityComponent
import com.visionvera.mdbase.di.component.DaggerActivityComponent
import com.visionvera.mdbase.di.module.ActivityModule
import com.visionvera.mdbase.di.module.LifecycleProviderModule
import com.visionvera.mdbase.presenter.BasePresenter
import com.visionvera.mdbase.presenter.view.BaseView
import com.visionvera.mdbase.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/*
    Activity基类，业务相关
 */
abstract open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent:ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }

    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }
}
