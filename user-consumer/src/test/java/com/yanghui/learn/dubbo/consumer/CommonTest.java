package com.yanghui.learn.dubbo.consumer;


import com.alibaba.fastjson.JSONObject;

/**
 * @author YangHui
 */
public class CommonTest {

    public static void main(String... args){

//        JSONObject.parseObject(result.getBody());

        JSONObject object = JSONObject.parseObject("{\"hasValidCredit\":\"Y\"}");
        System.out.println(object);
    }
}
