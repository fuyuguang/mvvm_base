package com.mvvm.test.di

import android.content.Context
import androidx.room.Room
import com.database.AppDatabase
import com.fyg.networklib.appContext
import com.fyg.networklib.retrofit.NetworkApiImp
import com.mvvm.test.net.ApiHomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by fuyuguang on 2022/11/18 5:09 PM.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 */
@InstallIn(SingletonComponent::class)
@Module
class NetWorkModule {

    @Provides
    @Singleton
    fun provideHomeServiceApi(): ApiHomeService {
        return NetworkApiImp.mRetrofit.create(ApiHomeService::class.java)
    }
}