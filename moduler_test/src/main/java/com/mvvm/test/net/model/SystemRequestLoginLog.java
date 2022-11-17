package com.mvvm.test.net.model;

public class SystemRequestLoginLog {

    /**
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
     }  */
    public String Id ;

    /// <summary>
    /// 用户ID
    /// </summary>
    public String UserId ;

    /// <summary>
    /// 用户名
    /// </summary>
    public String UserName ;

    /// <summary>
    /// 用户真实姓名
    /// </summary>
    public String UserRealName ;

    /// <summary>
    /// 登录系统（当前系统为：WMS-PDA）
    /// </summary>
    public String AppName ;

    /// <summary>
    /// 系统版本
    /// </summary>
    public String AppVersion ;

    /// <summary>
    /// 仓库ID
    /// </summary>
    public int WareId ;

    /// <summary>
    /// 登录IP
    /// </summary>
    public String IP ;

    /// <summary>
    /// 登录时间
    /// </summary>
    public long LoginTime ;

    /// <summary>
    /// 唯一标识符
    /// </summary>
    public String Guid ;

    /// <summary>
    /// 最后一次活跃时间
    /// </summary>
    public long LastHeartbeatTime ;

    /// <summary>
    /// 登出时间
    /// </summary>
    public long LogoutTime ;

    /// <summary>
    /// 备注
    /// </summary>
    public String Remark ;




}