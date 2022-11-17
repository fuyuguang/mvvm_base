package com.mvvm.test.net.model;

public class PDAUserInfo {
    /// <summary>
    ///唯一ID
    /// </summary>
    public int Id;

    /// <summary>
    /// 真实姓名
    /// </summary>
    public String Real_Name;

    /// <summary>
    /// 手机号码
    /// </summary>
    public String Mobile;

    /// <summary>
    /// 工号
    /// </summary>
    public String User_Code;

    /// <summary>
    /// 登录名
    /// </summary>
    public String User_Name;

    /// <summary>
    /// 密码
    /// </summary>
    public String Pass_Word;

    /// <summary>
    /// 1.表示采购一部 2.表示采购二部 3.表示采购三部 4.表示采购四部 5.表示采购五部'
    /// </summary>
    public int Department_Id;

    /// <summary>
    /// 上级部门ID =1 采购部
    /// </summary>
    public int Parent_Id;

    /// <summary>
    /// 添加时间
    /// </summary>
    public int Add_Time;

    /// <summary>
    /// 最后登录时间
    /// </summary>
    public int Last_Login;

    /// <summary>
    /// 最后登录IP
    /// </summary>
    public String Last_Ip;

    /// <summary>
    /// 角色ID
    /// </summary>
    public int Role_Id;

    /// <summary>
    /// 0表示非超级管理员 1表示超级管理员
    /// </summary>
    public Boolean Is_Admin;

    /// <summary>
    /// 0表示非部门领导  1表示部门领导
    /// </summary>
    public Boolean Is_Leader;

    public String Email;
    /// <summary>
    /// =0有效 =1无效
    /// </summary>
    public Boolean Valid;
    /// <summary>
    /// 库房ID
    /// </summary>
    public int WarehouseId;
    /// <summary>
    /// 事业部id
    /// </summary>
    public int Division_Id;
    /// <summary>
    /// 客服工号-与呼叫系统对接
    /// </summary>
    public String Customer_Code;

    public Boolean IsSelected;

    /// <summary>
    /// 库房Name
    /// </summary>
    public String WareName;

    public String ErrorMsg;
}