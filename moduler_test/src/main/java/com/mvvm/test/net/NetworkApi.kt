package com.mvvm.test.net

import com.fyg.networklib.retrofit.NetworkApiImp
import com.mvvm.test.net.ApiHomeService

/**
 * Created by fuyuguang on 2022/10/27 9:52 AM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
    []()
    []()
   如何向上层 Repo 暴露该 实例，如果写在 业务层，达不到复用的目的
 */
val apiService: ApiHomeService by lazy {
    NetworkApiImp.mRetrofit.create(ApiHomeService::class.java)
}

