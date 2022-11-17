package com.mvvm.test.net

import com.fyg.networklib.converter.ResponseFormat
import com.mvvm.test.net.model.PDAUserInfo
import com.mvvm.test.net.model.RequestPDAUserInfo
import com.mvvm.test.net.model.ResponseSystemLoginLog
import com.mvvm.test.net.model.WarehouseApi
import okhttp3.RequestBody
import retrofit2.http.*


/**
 * Created by fuyuguang on 2022/5/24 11:38 上午.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 * 该接口只能写在 业务数据层，因为和model 关联，参数默认值可能需要上下文等，针对 jx app 不能向上抽取
 */
interface ApiHomeService {

    companion object {
        /** http://172.16.37.180:8039/wmsapi/  */
        const val SERVER_URL = "http://172.16.37.180:8039/wmsapi/"
    }


    /** 打开页面调取获取仓库接口  */
    @GET("JxErpWarehouse?newSystem=true")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun getWarehouseApi(): List<WarehouseApi>



    /**
    a1,登录按钮验证账号密码
    请求方式：POST
    请求地址：login?userName={0}&passWord={1}&wareId={2}
    参数说明：
    userName 输入的账号
    passWord 输入的密码，请求接口时参数需MD5加密
    wareId   仓库ID，仓库下拉框选项的id

    响应示例：
    {
    "Id":"111",
    "Real_Name":"测试",
    "User_Code":"",
    "User_Name":"ceshi",
    "Pass_Word":"",
    "Email":"",
    "WarehouseId":9,
    "WareName":"广州二库"
    }
     */
    /** 没有 @Field的请求参数时，去掉该注解  */
//    @FormUrlEncoded
    @POST("login")
//    @Headers("Content-Type:application/json;charset=UTF-8")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun checkAccountAndPwdApi(
//        @Field("userName") username: String,
//        @Field("passWord") pwd: String,
//        @Field("wareId") verificationCode: String = "2"
        @Query("userName") username: String,
        @Query("passWord") pwd: String,
        @Query("wareId") verificationCode: String = "2"
    ): PDAUserInfo



    /**
    a2,获取当前登录用户的资源权限
    请求方式：POST
    请求地址：presources/userid/{0}/light?businessid=WMSPda
    参数说明：
    Userid：当前登录的用户ID
    businessid=WMSPda 为固定值，不可变
    响应示例：
    [
    "PDA01",
    "PDA0101",
    "PDA0102",
    "PDA0103",
    "PDA0104",
    "PDA0105"
    ]
    返回对象说明：返回资源权限list<string>
        []()
        */
//    @FormUrlEncoded
    @GET("presources/userid/{userid}/light?")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun getLoginUserRes(
        @Path("userid")  userid: String,
        @Query("businessid") businessid: String = "WMSPda",
    ): List<String>







    /**
    a3 ,获取当前登录用户的数据权限

    请求方式：GET
    请求地址：pdatarights/userid/{0}/light?datatype=5&businessId=WMS
    参数说明：
    Userid：当前登录的用户ID
    Datatype:数据类型，固定值5=商家店铺
    businessid=WMS为固定值，不可变
    响应示例：
    [
    "1112016116781",
    "144",
    "146"
    ]
    返回对象说明：返回数据权限list<string>
     */
    @GET("pdatarights/userid/{userid}/light?datatype=5&businessId=WMS")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun getLoginUserData(
        @Path("userid")  userid: String,
    ): List<String>





    /**
    a3,记录登录日志

    请求方式：POST
    请求地址：SystemLoginLog
    请求参数：
    {
    "UserId":111,
    "UserName":"ceshi",
    "UserRealName":"测试",
    "AppName":"WMS-PDA",
    "AppVersion":"22.9.22.1",
    "WareId":8,
    "IP":"172.1.2.1",
    "LoginTime":"2022/10/31 16:36:54",
    "Guid":"6540875b-a2b2-43f4-b361-165174eb564f",
    "LastHeartbeatTime":"2022/10/31 16:36:54",
    "LogoutTime":"",
    "Remark":null
    }
    参数说明：
        */
    @FormUrlEncoded
    @POST("SystemLoginLog")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun recodeLog(
        @Path("userid")  userid: String,
        @Field("businessid") businessid: String = "WMSPda",
    ): List<String>





    /**


    记录登录日志

    请求方式：POST
    请求地址：SystemLoginLog
    请求参数：
    {
    "UserId":111,
    "UserName":"ceshi",
    "UserRealName":"测试",
    "AppName":"WMS-PDA",
    "AppVersion":"22.9.22.1",
    "WareId":8,
    "IP":"172.1.2.1",
    "LoginTime":"2022/10/31 16:36:54",
    "Guid":"6540875b-a2b2-43f4-b361-165174eb564f",
    "LastHeartbeatTime":"2022/10/31 16:36:54",
    "LogoutTime":"",
    "Remark":null
    }
    参数说明：

    使用@body标签时不能用@FormUrlEncoded标签，不然会报以下异常：
    java.lang.IllegalArgumentException: @Body parameters cannot be used with form or multi-part encoding. (parameter #1)

     */
    @POST("SystemLoginLog")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun loginWithRequestBody(@Body param: RequestBody): ResponseSystemLoginLog

    @POST("SystemLoginLog")
    @ResponseFormat(value = ResponseFormat.FASTJSON,filterEmpty = false)
    suspend fun loginWithBean(@Body param: RequestPDAUserInfo): ResponseSystemLoginLog




}