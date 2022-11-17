package com.mvvm.test.net.model;

public class ResponseSystemLoginLog {

    /**
     {
     "Result":1,
     "Message":"",
     "DictionaryResult":{
     "Id":27784
     }
     }

     返回对象说明：
     Result:1=成功 0=失败
     Message:提示信息,主要用于显示失败信息
     DictionaryResult:返回结果
     Id:登录日志的自增ID
     */
    public int Result ;

    /// <summary>
    /// 用户ID
    /// </summary>
    public String Message ;

    /// <summary>
    /// 用户名
    /// </summary>
    public DictionaryResult DictionaryResult ;


    public static class DictionaryResult{
        public long Id ;
    }



}