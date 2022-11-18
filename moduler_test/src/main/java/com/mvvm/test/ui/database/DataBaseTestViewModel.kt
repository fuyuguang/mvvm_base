package com.mvvm.test.ui.database
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.database.AppDatabase
import com.database.data.model.Note
import com.mvvm.baseapp.IDataSource

import com.mvvm.baseapp.viewmodel.BaseViewModel
import com.mvvm.test.WMSApp
import com.mvvm.test.ui.login.LoginDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by fuyuguang on 2022/7/20 11:11 上午.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 */
//class DataBaseTestViewModel : BaseViewModel<IDataSource>() {
class DataBaseTestViewModel @Inject constructor(private val mDataSource : LoginDataSource): BaseViewModel<IDataSource>(mDataSource) {

//    /** 酒仙后台数据格式  */
////    val mHomeRecommendLiveDataWithResource = MutableLiveData<Resource<ApiResponse<ApiHomePagerResponse<ArrayList<HomeWineList>>>>>()
//    val mHomeRecommendLiveDataWithResource = MutableLiveData<Resource<ApiHomePagerResponse<ArrayList<HomeWineList>>>>()
//    /** 自定义数据格式  */
//    val mHomeRecommendLiveDataWithCustomResource = MutableLiveData<CustomResource<ApiResponse<ApiHomePagerResponse<ArrayList<HomeWineList>>>>>()
//    /** 修改用户信息  */
//    val modificationUserInfoLiveDataWithResource = MutableLiveData<Resource<EmptyResult>>()





    fun insertNote(noteContent: Note) {


        viewModelScope.launch(Dispatchers.IO) {
            AppDatabase.getInstance(WMSApp.instance).getNoteDao().insertNote(Collections.singletonList(noteContent))
        }
    }


    fun updateNote(noteContent: Note) {
        viewModelScope.launch(Dispatchers.IO) {
           AppDatabase.getInstance(WMSApp.instance).getNoteDao().updateNote(noteContent)
        }
    }

    fun deleteNote(noteContent: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            AppDatabase.getInstance(WMSApp.instance).getNoteDao().deleteNote(noteContent)
        }
    }


    fun getAllNotes() =
        AppDatabase.getInstance(WMSApp.instance).getNoteDao().getAllNotes().asCustomResourceFlow().asLiveData()


    fun getNoteByID(id: Int) =
        AppDatabase.getInstance(WMSApp.instance).getNoteDao().getNoteByID(id).asCustomResourceFlow().asLiveData()


    fun deleteNoteByID(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            AppDatabase.getInstance(WMSApp.instance).getNoteDao().deleteNoteByID(id)
        }
    }

    fun getAllNotesWithLiveData(){
        AppDatabase.getInstance(WMSApp.instance).getNoteDao().getAllNotesWithLiveData().asFlow().asCustomResourceFlow().asLiveData()
    }

}