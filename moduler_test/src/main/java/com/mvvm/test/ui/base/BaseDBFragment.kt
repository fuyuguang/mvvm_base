package com.mvvm.test.ui.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.fyg.dialog.loading.DialogLoading
import com.fyg.networklib.callbacklib.LifeCycleCallback.ILoadingView
import com.mvvm.baseapp.fragment.BaseVmDbFragment
import com.mvvm.baseapp.viewmodel.BaseViewModel


abstract class BaseDBFragment<VM : BaseViewModel<*>, DB : ViewDataBinding> : BaseVmDbFragment<VM, DB>(), ILoadingView {

//    private var mDialogLoading: DialogLoading? = null
//    var mDialogLoading = ProgressDialog(this)
    protected var mLinkId = 0


    override fun createObserver(){}


    fun onBackPressed(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mDialogLoading = DialogLoading(mActivity)
        bindView()
        initLinkId()
    }



    private fun bindView() {

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    /**
     * current fragment resume
     */
    fun onCurrentResume() {}
    fun onCurrentPause() {}
     override fun showLoadingDialog() {
        if (mActivity is BaseDBActivity<*, *>) {
            val baseActivity = mActivity as BaseDBActivity<*, *>
            baseActivity.showLoadingDialog()
            return
        }
        if (isAdded) {
            try {
                if (!mDialogLoading.isShowing) {
                    mDialogLoading.show()
                }
            } catch (e: Exception) {
            }
        }
    }

    override fun dismissLoadingDialog() {
        if (mActivity is BaseDBActivity<*, *>) {
            val baseActivity = mActivity as BaseDBActivity<*, *>
            baseActivity.dismissLoadingDialog()
            return
        }
        try {
            mDialogLoading.dismiss()
        } catch (e: Exception) {
        }
    }


    override fun onDetach() {
        super.onDetach()
        dismissLoadingDialog()
    }


    private fun initLinkId() {

    }



    override fun onDestroy() {
        super.onDestroy()

    }


    private lateinit var mDialogLoading: DialogLoading


    override fun preInit() {
        mDialogLoading = DialogLoading(this.mActivity)
    }

}