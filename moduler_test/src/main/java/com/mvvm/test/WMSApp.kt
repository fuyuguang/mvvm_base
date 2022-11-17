package com.mvvm.test

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.multidex.MultiDex
import com.fyg.networklib.BaseResponse
import com.fyg.networklib.IShowToast
import com.fyg.networklib.ITokenExpired
import com.fyg.networklib.NetWorkManager
import com.fyg.networklib.model.bean.ApiResponse.Companion.isTokenDated
import com.mvvm.WMSEnv
import com.mvvm.test.net.ApiHomeService
import kotlin.properties.Delegates

/**
 * Created by fuyuguang on 2022/10/21 3:42 PM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 */
class WMSApp : Application() {


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        addDebugInfo()
        initNetWorkManager();
    }

    companion object{
        var instance: Application by Delegates.notNull()
    }


    private fun initNetWorkManager() {
        NetWorkManager.init(object : ITokenExpired {
            override fun isExpired(data: BaseResponse<*>?): Boolean {
                return isTokenDated(data)
            }

            override fun tokenExpiredHandler(data: BaseResponse<*>?) {
//                UserInfoManager.userTokenDatedHandle(data)
            }
        }, { mutableMapOf() }, object : IShowToast {
            override fun showShort(data: String) {
                Toast.makeText(instance,data,Toast.LENGTH_LONG).show()
            }

            override fun showDebugShort(data: String) {
                Toast.makeText(instance,data,Toast.LENGTH_LONG).show()
            }
        }, ApiHomeService.SERVER_URL,
            { }, WMSEnv.DEBUG
        )
    }


    fun addDebugInfo(){
        if (BuildConfig.DEBUG) {
            System.setProperty(
                kotlinx.coroutines.DEBUG_PROPERTY_NAME,
                kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
            )
        }
    }

}