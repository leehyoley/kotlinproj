package com.visionvera.mdbase.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.visionvera.mdbase.common.BaseApplication
import com.visionvera.mdbase.di.component.ActivityComponent
import com.visionvera.mdbase.di.component.DaggerActivityComponent
import com.visionvera.mdbase.di.module.ActivityModule
import com.visionvera.mdbase.di.module.LifecycleProviderModule
import com.visionvera.mdbase.presenter.BasePresenter
import com.visionvera.mdbase.presenter.view.BaseView
import com.visionvera.mdbase.widgets.ProgressLoading
import javax.inject.Inject

/*
    Fragment基类，业务相关
 */
abstract open class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(context!!)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始化Activity级别Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
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
        Toast.makeText(context,"错误",Toast.LENGTH_SHORT)
    }
}
