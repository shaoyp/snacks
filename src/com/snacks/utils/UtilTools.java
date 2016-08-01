package com.snacks.utils;

/**
 * Created by Jerry Wang on 16/7/29.
 */
public class UtilTools {

    private static UtilTools instance;

    public static UtilTools getInstance(){
        if(instance == null){
            instance = new UtilTools();
        }
        return instance;
    }

    /**
     * 获取序列号
     * @param s
     * @return
     */
    public static String getSequence(String s){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }

}
