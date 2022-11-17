package com.mvvm.test.ui.login


//class LoginViewModel : BaseViewModel() {
//
////    private val _text = MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>>()
////    val text: MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>> = _text
//
////    private val _text = MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>>()
////    val text: MutableLiveData<CustomResource<ApiResponse<List<WarehouseApi>>>> = _text
//
//
//    private lateinit var mPDAUserInfo: PDAUserInfo
//    private val _text = MutableLiveData<CustomResource<List<WarehouseApi>>>()
//    val warehouseLiveData: MutableLiveData<CustomResource<List<WarehouseApi>>> = _text
//
//    val responseSystemLoginLogLiveData: MutableLiveData<CustomResource<ResponseSystemLoginLog>> = MutableLiveData<CustomResource<ResponseSystemLoginLog>>()
//
//
////    MutableLiveData<CustomResource<ApiResponse<ApiHomePagerResponse<ArrayList<HomeWineList>>>>>()
//
////    fun getWarehouseApi(){
////        loadDataWithCustomResourceFlow(text,createFlow { getWarehouseApi() })
////    }
//
//    fun getWarehouseApi(
//        liveData: MutableLiveData<*>
//    ) {
//        loadDataWithCustomResourceFlow(liveData) {
//            createFlow {
//                apiService.getWarehouseApi()
//            }
//        }
//    }
//
//    fun checkAccountAndPwdApi(
//        liveData: MutableLiveData<*>,
//        userName: String,
//        passWord: String,
//        wareId: String = "84",
//    ) {
//        val checkAccountAndPwdApi = createFlow {
//            apiService.checkAccountAndPwdApi(userName, MD5.getMD5(passWord),wareId)
//        }
//
//        var loginUserRes =  checkAccountAndPwdApi.transform {
//            if (TextUtils.isEmpty(it.ErrorMsg)){
//                mPDAUserInfo = it;
//                emit(createFlow {
//                    apiService.getLoginUserRes(it.Id.toString())
//                })
//            }else{
//                mUiStatus2.postValue(CustomResource.verifyError(it.ErrorMsg))
//            }
//        }
//
//        var loginUserData =  loginUserRes.flatMapConcat { it ->
//            createFlow {
//                apiService.getLoginUserData(mPDAUserInfo.Id.toString())
//            }
//        }
//
//        var login = loginUserData.flatMapConcat { it ->
//            createFlow {
//
//                var requestPDAUserInfo = RequestPDAUserInfo()
//                requestPDAUserInfo.UserId = mPDAUserInfo.Id
//                requestPDAUserInfo.UserName = mPDAUserInfo.User_Name
//                requestPDAUserInfo.UserRealName = mPDAUserInfo.Real_Name
//                requestPDAUserInfo.AppName = "发电房试试"
//                requestPDAUserInfo.AppVersion = "9.0.28"
//                requestPDAUserInfo.WareId = wareId
//                requestPDAUserInfo.IP = "192.168.1.102"
//                requestPDAUserInfo.LoginTime = "2022/11/2 18:36:54"
//                requestPDAUserInfo.Guid = "6540875b-a2b2-43f4-b361-165174eb564f"
//                requestPDAUserInfo.LastHeartbeatTime = "2022/11/2 18:36:54"
//                requestPDAUserInfo.LogoutTime = ""
//                requestPDAUserInfo.Remark = ""
//
//
////                val requestBody: RequestBody =
////                    RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(requestPDAUserInfo))
////                apiService.loginWithRequestBody(requestBody)
//                apiService.loginWithBean(requestPDAUserInfo)
//            }
//        }
//
//        loadDataWithCustomResourceFlow2(login,liveData,this.mUiStatus2)
//    }
//
//    override fun createDataSource(): IDataSource? {
//        return LoginDataSource()
//    }
//
//
//}