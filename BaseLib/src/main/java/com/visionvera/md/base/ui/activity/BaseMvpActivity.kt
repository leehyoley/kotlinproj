package com.visionvera.md.base.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.visionvera.md.base.common.BaseApplication
import com.visionvera.md.base.di.component.ActivityComponent
import com.visionvera.md.base.di.component.DaggerActivityComponent
import com.visionvera.md.base.di.module.ActivityModule
import com.visionvera.md.base.di.module.LifecycleProviderModule
import com.visionvera.md.base.presenter.BasePresenter
import com.visionvera.md.base.presenter.view.BaseView
import com.visionvera.md.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import java.lang.reflect.Method
import java.util.*
import javax.inject.Inject

/*
    Activity基类，业务相关
    C为component接口类
    M为module接口类
 */
abstract open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

     var mActivityComponent:ActivityComponent? = null
        get() = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        mPresenter.setMyView(this)
        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    /*
        Dagger注入
     */
    protected abstract fun injectComponent()

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

    /*
    开始想通过反射初始Activity Component，可省去样板代码，但效率低，有违dagger初衷，先保留备用
    */
    /*
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
        val idArr = getDiClasses()
        if (idArr.size==2){

            var classname = StringBuilder().append(idArr[0].`package`.name).append(".Dagger").append(idArr[0].simpleName).toString()

            val componentClass = Class.forName(classname)
            val moduleClass = idArr[1]

            //DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)

            val builderMethod = componentClass.getMethod("builder")
            var builderInstance = builderMethod.invoke(componentClass)

            val componentBuilderClass = Class.forName(StringBuilder().append(classname).append("\$Builder").toString())

            val activityComponentMethod = componentBuilderClass.getMethod("activityComponent",ActivityComponent::class.java)
            builderInstance = activityComponentMethod.invoke(builderInstance,mActivityComponent)


            var moduleMethodName = moduleClass.toString().split(".").last()
            if (Character.isUpperCase(moduleMethodName!![0])){
                moduleMethodName = StringBuilder().append(Character.toLowerCase(moduleMethodName[0])).append(moduleMethodName.substring(1)).toString()
            }
            val moduleMethod = componentBuilderClass.getMethod(moduleMethodName,moduleClass)
            builderInstance = moduleMethod.invoke(builderInstance,moduleClass.newInstance())

            val buildMethod = componentBuilderClass.getMethod("build")
            val componentInstance = buildMethod.invoke(builderInstance)

            val injectMethod = componentClass.getMethod("inject",this.javaClass)
            injectMethod.invoke(componentInstance,this)

            mPresenter.setCommenView(this)
//            mPresenter.mView = this as LoginView

        }
    }
*/
}
