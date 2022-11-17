package com.mvvm.test.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mvvm.baseapp.ext.observerCustomResource
import com.mvvm.test.databinding.FragmentLoginBinding
import com.mvvm.test.ui.base.BaseDBFragment

class LoginFragment : BaseDBFragment<LoginViewModelTest, FragmentLoginBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        mViewModel.getWarehouseApi(mViewModel.warehouseLiveData);

        mDatabind?.apply {
            login.setOnClickListener {
                //mViewModel.checkAccountAndPwdApi2(mViewModel.responseSystemLoginLogLiveData,account.text.toString(),pwd.text.toString(),warehouse.text.toString())
                mViewModel.checkAccountAndPwdApi2(account.text.toString(),pwd.text.toString(),warehouse.text.toString())
            }
        }
    }

    override fun createObserver() {
        super.createObserver()

        observerCustomResource(mViewModel.warehouseLiveData,{ it ->

            it?.apply {
                if (isNotEmpty()){
                    forEach {
                        Log.e("FYG","$it.Title  --   ${it.WareName}  --   $it.SystemType  --    $it.Id  --   ");
                    }
                }
            }
        })




         observerCustomResource(mViewModel.responseSystemLoginLogLiveData,{ it ->

            it?.apply {

                when(Result){
                    0 -> {
                        Toast.makeText(mActivity,Message,Toast.LENGTH_LONG).show()
                    }
                    1 -> {

                        DictionaryResult?.apply {
                            Toast.makeText(mActivity,"登录成功 ： $Id",Toast.LENGTH_LONG).show()
                        }

                    }
                }
            }
        })

    }


    override fun onDestroy() {
        super.onDestroy()
    }

}