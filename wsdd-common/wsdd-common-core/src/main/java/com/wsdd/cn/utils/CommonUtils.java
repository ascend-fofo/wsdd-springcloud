package com.wsdd.cn.utils;

import java.util.UUID;

public class CommonUtils {

    public static String generatorUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

    }
}
