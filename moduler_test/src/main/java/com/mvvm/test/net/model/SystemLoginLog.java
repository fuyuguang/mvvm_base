package com.mvvm.test.net.model;

public class SystemLoginLog {
    public long Id ;

    /// <summary>
    /// 用户ID
    /// </summary>
    public int UserId ;

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

    public String ErrorMsg;
}