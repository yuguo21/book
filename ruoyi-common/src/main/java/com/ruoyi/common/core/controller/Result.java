package com.ruoyi.common.core.controller;

import java.util.HashMap;
import java.util.Map;

public class Result {
    
    public static Map<String, Object> resultEntity (int code, String msg, Object vo){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        resultMap.put("data", vo);
        return resultMap;
    }

    public static Map<String, Object> resultEntity (int code, String msg){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }

}
