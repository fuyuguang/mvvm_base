package com.mvvm.test.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fyg.networklib.result.CustomResource
import com.mvvm.baseapp.viewmodel.BaseViewModel
import com.mvvm.test.net.model.PDAUserInfo
import com.mvvm.test.net.model.ResponseSystemLoginLog
import com.mvvm.test.net.model.WarehouseApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by fuyuguang on 2022/11/14 4:56 PM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
    []()
    []()

 */
@HiltViewModel
class LoginViewModelTest @Inject constructor(private val mDataSource : LoginDataSource): BaseViewModel<LoginDataSource>(mDataSource) {

//    private val _text = MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>>()
//    val text: MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>> = _text

//    private val _text = MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>>()
//    val text: MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>> = _text


    private lateinit var mPDAUserInfo: PDAUserInfo
    private val _text = MutableLiveData<CustomResource<List<WarehouseApi>>>()
    val warehouseLiveData: MutableLiveData<CustomResource<List<WarehouseApi>>> = _text

    val responseSystemLoginLogLiveData: MutableLiveData<CustomResource<ResponseSystemLoginLog>> = MutableLiveData<CustomResource<ResponseSystemLoginLog>>()

//     var mWareHousesLiveData: MutableLiveData<List<WarehouseApi>>
    fun getWarehouseApi(
        liveData: MutableLiveData<*>
    ) {
        mDataSource.getWarehouseApi{ it ->
            it.parseResponseWithUiState(mUiStatus,{
                this?.let {
//                    mWareHousesLiveData.value = it
                }
            })
        }
    }



    fun checkAccountAndPwdApi2(
        userName: String,
        passWord: String,
        wareId: String = "84",
    ) {

//        mDataSource.checkAccountAndPwdApi2(userName,passWord,wareId){ it ->
//            it.parseResponseWithUiState(mUiStatus,{
//                this.let {
//                    var sss = it;
//                }
//            })
//
//        }
//
//        mDataSource.checkAccountAndPwdApi22(userName,passWord,wareId){ it ->
//            it.parseResponseWithUiState(mUiStatus,{
//
//                this.let {
//                    var sss = it;
//                }
//            })
//
//        }

        mDataSource.checkAccountAndPwdApi222(userName,passWord,wareId).onEach {
            it.parseResponseWithUiState(mUiStatus,{
                  this?.apply {
                      var ss  = this;
                  }

            },{

            })
        }.launchIn(viewModelScope)

//        mDataSource.checkAccountAndPwdApi2222<ResponseSystemLoginLog>(userName,passWord,wareId){
//
//        }

    }


}