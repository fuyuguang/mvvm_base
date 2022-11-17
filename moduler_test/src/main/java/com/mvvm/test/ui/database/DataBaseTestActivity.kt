package com.mvvm.test.ui.database


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isDigitsOnly
import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.LinearLayoutManager
import com.database.data.model.Note
import com.mvvm.baseapp.ext.observerCustomResource
import com.mvvm.comm.whatIfNotNullOrEmpty
import com.mvvm.test.databinding.ActivityDatabaseTestBinding
import com.mvvm.test.ui.base.BaseDBActivity

/**
 * Created by fuyuguang on 2022/7/20 10:39 上午.
 * E-Mail ：2355245065@qq.com
 * Wechat :fyg13522647431
 * Tel : 13522647431
 * 修改时间：
 * 类描述：
 * 备注：
 */
class DataBaseTestActivity: BaseDBActivity<DataBaseTestViewModel, ActivityDatabaseTestBinding>() {

    private var singleNote: Note? = null
    override val pageName: String get() = "DataBaseTestActivity"
    private  var noteAdapter: NoteAdapter  = NoteAdapter()
    private  var noteAdapterWithLiveData: NoteAdapter  = NoteAdapter()
    private  var singleNoteAdapter: NoteAdapter  = NoteAdapter()
    override fun initView(savedInstanceState: Bundle?) {

        mDatabind.apply {
            mFlowRecyclerView.adapter = noteAdapter
            mFlowRecyclerView.layoutManager = LinearLayoutManager(mActivity)

            mLiveDataRecyclerView.adapter = noteAdapterWithLiveData
            mLiveDataRecyclerView.layoutManager = LinearLayoutManager(mActivity)

            mSingleRecyclerView.adapter = singleNoteAdapter
            mSingleRecyclerView.layoutManager  = LinearLayoutManager(mActivity)
        }
        initClickEvent()

    }

    var count = 0
    private fun createNote(content:String) : Note {
        return Note(
            date = content,
//            createdAt = System.currentTimeMillis(),
//            id = count++
        )
    }

    private fun initClickEvent(){

        mDatabind.apply {

            mAddBtn.setOnClickListener {

                mViewModel.insertNote(createNote(mAddText.text.toString()))
            }

            mDeleteBtnByID.setOnClickListener {
                if (!TextUtils.isEmpty(mDeleteText.text.toString()) &&  mDeleteText.text.toString().isDigitsOnly()){
                    mViewModel.deleteNoteByID(mDeleteText.text.toString().toInt())
                }
            }

            mDeleteBtnByBean.setOnClickListener {
                singleNote?.apply {
                    mViewModel.deleteNote(this)
                    singleNote = null
                }
            }


            mUpdateBtm.setOnClickListener {
                singleNote?.apply {
                    date = mUpdateText.text.toString();
                    mViewModel.updateNote(this)
                }

            }

            mQueryBtn.setOnClickListener {

                mQueryText.text.toString().whatIfNotNullOrEmpty {

                    if (isDigitsOnly(this)) {
                        observerCustomResource(mViewModel.getNoteByID(this.toInt()), {
                            if (it !=null){
                                singleNote = it;
                                singleNoteAdapter.differ.submitList(listOf(it))
                                Log.e("single item ",it?.date +"   "+ it?.id)
                            }else{
                                Log.e("single item ","  Transaction == null ")
                                singleNoteAdapter.differ.submitList(listOf())
                            }
                        })
                    }
                }
            }

            mQueryAllBtn.setOnClickListener {

                observerCustomResource(mViewModel.getAllNotes(),{
                    it?.forEach {
                        Log.e("all item ",it.date +"   "+ it.id)
                    }
                    noteAdapter.differ.submitList(it)
                })
            }

            mQueryAllBtnWithLiveData.setOnClickListener {

                observerCustomResource(mViewModel.getAllNotes(),{
                    it?.forEach {
                        Log.e("all item ",it.date +"   "+ it.id)
                    }
                    noteAdapterWithLiveData.differ.submitList(it)
                })
            }
        }
    }





    companion object{

        fun gotoCustomDataBaseActivity(context: Activity) {
            val intent = Intent(context, DataBaseTestActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }

    }
}