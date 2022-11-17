package com.mvvm.test.ui.login

import android.text.TextUtils
import com.fyg.networklib.callbacklib.exception.BusinessError
import com.fyg.networklib.model.bean.UserInfo
import com.fyg.networklib.result.CustomResource
import com.mvvm.baseapp.IDataSource
import com.mvvm.comm.MD5
import com.mvvm.test.net.apiService
import com.mvvm.test.net.model.PDAUserInfo
import com.mvvm.test.net.model.RequestPDAUserInfo
import com.mvvm.test.net.model.ResponseSystemLoginLog
import com.mvvm.test.net.model.WarehouseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by fuyuguang on 2022/11/10 9:41 PM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 */
class LoginDataSource : IDataSource() {


    fun getWarehouseApi(action: suspend (CustomResource<List<WarehouseApi>>) -> Unit) {
        mCoroutineScope.launch {
            createFlow { apiService.getWarehouseApi()}.asCustomResourceFlow().collect {
                action(it)
            }
        }
    }

    private lateinit var mPDAUserInfo: PDAUserInfo
    fun checkAccountAndPwdApi(
                              userName: String,
                              passWord: String,
                              wareId: String = "84", action: suspend (CustomResource<ResponseSystemLoginLog>) -> Unit) {
        mCoroutineScope.launch {

            val checkAccountAndPwdApi = createFlow {
                apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
            }

            var loginUserRes =  checkAccountAndPwdApi.transform {
                Thread.sleep(2000)
                if (TextUtils.isEmpty(it.ErrorMsg)){
                    mPDAUserInfo = it;
                    emit(createFlow {
                        apiService.getLoginUserRes(it.Id.toString())
                    })
                }else{
                    throw BusinessError.createBusinessError(it.ErrorMsg)
                }
            }

            var loginUserData =  loginUserRes.flatMapConcat { it ->
                createFlow {
                    apiService.getLoginUserData(mPDAUserInfo.Id.toString())
                }
            }

            var login = loginUserData.flatMapConcat { it ->
                createFlow {

                    var requestPDAUserInfo = RequestPDAUserInfo()
                    requestPDAUserInfo.UserId = mPDAUserInfo.Id
                    requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
                    requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
                    requestPDAUserInfo.AppName = "发电房试试"
                    requestPDAUserInfo.AppVersion = "9.0.28"
                    requestPDAUserInfo.WareId = wareId
                    requestPDAUserInfo.IP = "192.168.1.102"
                    requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
                    requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.LogoutTime = ""
                    requestPDAUserInfo.Remark = ""

                    apiService.loginWithBean(requestPDAUserInfo)
                }
            }
            //loadDataWithCustomResourceFlow2(login,liveData,this.mUiStatus2)
            login.asCustomResourceFlow().collect {
                action(it)
            }
        }
    }





    fun checkAccountAndPwdApi2(
        userName: String,
        passWord: String,
        wareId: String = "84", action: suspend (CustomResource<ResponseSystemLoginLog>) -> Unit) {
        mCoroutineScope.launch {

            val checkAccountAndPwdApi = createFlow {
                apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
            }
            var loginUserRes =  checkAccountAndPwdApi.flatMapConcat {
                Thread.sleep(2000)

                if (TextUtils.isEmpty(it.ErrorMsg)){
                    mPDAUserInfo = it;
                    createFlow {
                        apiService.getLoginUserRes(it.Id.toString())
                    }
                }else{
                    throw BusinessError.createBusinessError(it.ErrorMsg)
                }
            }

            var loginUserData =  loginUserRes.flatMapConcat {
                createFlow {
                    apiService.getLoginUserData(mPDAUserInfo.Id.toString())
                }
            }

            var login = loginUserData.flatMapConcat {
                createFlow {
                    var requestPDAUserInfo = RequestPDAUserInfo()
                    requestPDAUserInfo.UserId = mPDAUserInfo.Id
                    requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
                    requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
                    requestPDAUserInfo.AppName = "发电房试试"
                    requestPDAUserInfo.AppVersion = "9.0.28"
                    requestPDAUserInfo.WareId = wareId
                    requestPDAUserInfo.IP = "192.168.1.102"
                    requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
                    requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.LogoutTime = ""
                    requestPDAUserInfo.Remark = ""
                    apiService.loginWithBean(requestPDAUserInfo)

                }
            }
            login.asCustomResourceFlow().collect {
                action(it)
            }
        }
    }




     fun < T> checkAccountAndPwdApi2222(
        userName: String,
        passWord: String,
        wareId: String = "84", action:  (T) -> Unit) {
        mCoroutineScope.launch {
            val checkAccountAndPwdApi = createFlow {
                apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
            }
            var loginUserRes =  checkAccountAndPwdApi.flatMapConcat {
                Thread.sleep(2000)

                if (TextUtils.isEmpty(it.ErrorMsg)){
                    mPDAUserInfo = it;
                    createFlow {
                        apiService.getLoginUserRes(it.Id.toString())

                    }
                }else{
                    throw BusinessError.createBusinessError(it.ErrorMsg)
                }
            }

            var loginUserData =  loginUserRes.flatMapConcat {
                createFlow {
                    apiService.getLoginUserData(mPDAUserInfo.Id.toString())
                }
            }

            var login = loginUserData.flatMapConcat {
                createFlow {
                    var requestPDAUserInfo = RequestPDAUserInfo()
                    requestPDAUserInfo.UserId = mPDAUserInfo.Id
                    requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
                    requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
                    requestPDAUserInfo.AppName = "发电房试试"
                    requestPDAUserInfo.AppVersion = "9.0.28"
                    requestPDAUserInfo.WareId = wareId
                    requestPDAUserInfo.IP = "192.168.1.102"
                    requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
                    requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.LogoutTime = ""
                    requestPDAUserInfo.Remark = ""
                    apiService.loginWithBean(requestPDAUserInfo)

                }
            }
            login.asCustomResourceFlow().collect {
                it.parseResponseWithUiState2(it,null,{
                    this.let {
                        action(it as T)
                    }
                })
            }
        }
    }






    fun checkAccountAndPwdApi22(
        userName: String,
        passWord: String,
        wareId: String = "84", action: suspend (CustomResource<UserInfo>) -> Unit) {
        mCoroutineScope.launch {

            val checkAccountAndPwdApi = createFlow {
                apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
            }
            var loginUserRes =  checkAccountAndPwdApi.flatMapConcat {
                Thread.sleep(2000)

                if (TextUtils.isEmpty(it.ErrorMsg)){
                    mPDAUserInfo = it;
                    createFlow {
                        apiService.getLoginUserRes(it.Id.toString())
                    }
                }else{
                    throw BusinessError.createBusinessError(it.ErrorMsg)
                }
            }

            var loginUserData =  loginUserRes.flatMapConcat {
                createFlow {
                    apiService.getLoginUserData(mPDAUserInfo.Id.toString())
                }
            }

            var login = loginUserData.flatMapConcat {
                createFlow {
                    var requestPDAUserInfo = RequestPDAUserInfo()
                    requestPDAUserInfo.UserId = mPDAUserInfo.Id
                    requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
                    requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
                    requestPDAUserInfo.AppName = "发电房试试"
                    requestPDAUserInfo.AppVersion = "9.0.28"
                    requestPDAUserInfo.WareId = wareId
                    requestPDAUserInfo.IP = "192.168.1.102"
                    requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
                    requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.LogoutTime = ""
                    requestPDAUserInfo.Remark = ""
                    apiService.loginWithBean(requestPDAUserInfo)

                }
            }
            login.flowOn(Dispatchers.IO).transform {
                var userInfo = UserInfo()
                userInfo.nickname =  it.Message
                emit(userInfo)
            }.asCustomResourceFlow().
            collect {
                action(it)
            }
        }
    }






    fun checkAccountAndPwdApi222(
        userName: String,
        passWord: String,
        wareId: String = "84",
    ) : Flow<CustomResource<UserInfo>> {
            val checkAccountAndPwdApi = createFlow {
                apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
            }
            var loginUserRes =  checkAccountAndPwdApi.flatMapConcat {
                Thread.sleep(2000)

                if (TextUtils.isEmpty(it.ErrorMsg)){
                    mPDAUserInfo = it;
                    createFlow {
                        apiService.getLoginUserRes(it.Id.toString())
                    }
                }else{
                    throw BusinessError.createBusinessError(it.ErrorMsg)
                }
            }

            var loginUserData =  loginUserRes.flatMapConcat {
                createFlow {
                    apiService.getLoginUserData(mPDAUserInfo.Id.toString())
                }
            }

            var login = loginUserData.flatMapConcat {
                createFlow {
                    var requestPDAUserInfo = RequestPDAUserInfo()
                    requestPDAUserInfo.UserId = mPDAUserInfo.Id
                    requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
                    requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
                    requestPDAUserInfo.AppName = "发电房试试"
                    requestPDAUserInfo.AppVersion = "9.0.28"
                    requestPDAUserInfo.WareId = wareId
                    requestPDAUserInfo.IP = "192.168.1.102"
                    requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
                    requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
                    requestPDAUserInfo.LogoutTime = ""
                    requestPDAUserInfo.Remark = ""
                    apiService.loginWithBean(requestPDAUserInfo)

                }
            }
            return login.flowOn(Dispatchers.IO).transform {
                var userInfo = UserInfo()
                userInfo.nickname =  it.Message
                emit(userInfo)
            }.asCustomResourceFlow()
    }


}