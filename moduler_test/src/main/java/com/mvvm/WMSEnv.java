package com.mvvm;

public class WMSEnv {
    /**
     * debug开关（发布设置为false）
     */
    public static boolean DEBUG = true;

    /**
     * 发布版本开关（发布设置为true）
     */
    private static boolean RELEASE = true;


    @Deprecated
    public static final boolean isDebugData = false && WMSEnv.DEBUG;
    /**
     * 8.6.3
     */
    public static final boolean isHideJxPrice = true;
}
