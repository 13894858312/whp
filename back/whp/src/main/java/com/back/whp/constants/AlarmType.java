package com.back.whp.constants;

import java.util.HashMap;

public class AlarmType {
    public static final HashMap<String, Integer> alarmTypeS2I = new HashMap<String, Integer>()

    {
        {
            put("类型1", 1);
            put("类型2", 2);
            put("类型3", 3);
            put("类型4", 4);
            put("类型5", 5);
            put("类型6", 6);
        }
    };

    public static final HashMap<Integer, String> alarmTypeI2S = new HashMap<Integer, String>()

    {
        {
            put(1, "类型1");
            put(2, "类型2");
            put(3, "类型3");
            put(4, "类型4");
            put(5, "类型5");
            put(6, "类型6");
        }
    };
}
