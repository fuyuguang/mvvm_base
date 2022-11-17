package com.mvvm.test.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.fyg.networklib.callbacklib.LifeCycleCallback.ILoadingView
import com.mvvm.baseapp.activity.BaseVmDbActivity
import com.mvvm.baseapp.viewmodel.BaseViewModel

abstract class BaseDBActivity<VM : BaseViewModel<*>, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() ,
    ILoadingView {

    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    /**
     * 打开等待框
     */
    override fun showLoadingDialog() {
        try {
            mDialogLoading?.apply {
                if (!isFinishing and !isShowing){
                    show()
                }
            }
        }catch (e : Exception){

        }

    }

    /**
     * 关闭等待框
     */
    override fun dismissLoadingDialog() {

        try {
            mDialogLoading?.apply {
                dismiss()
            }
        }catch (e : Exception){

        }

    }



   protected abstract val pageName: String



    private var mDialogLoading: ProgressDialog? = null


    override fun preInit() {
        mDialogLoading = ProgressDialog(this)
    }

}