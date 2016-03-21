package com.elite.buylist.constant;

import com.google.common.collect.Maps;

import java.util.EnumSet;
import java.util.Map;

/**
 * Create by wjc133
 * Date: 2016/3/21
 * Time: 14:33
 */
public enum EnvType {
    DEV(1, "develop env"),
    TEST(2, "test env"),
    PRODUCT(3, "product env"),
    UNKNOWN(9, "unknown");

    private Byte code;
    private String message;

    private static Map<Byte, EnvType> envMap = Maps.newHashMap();

    static {
        for (EnvType envType : EnumSet.allOf(EnvType.class)) {
            envMap.put(envType.code, envType);
        }
    }

    EnvType(Integer code, String message) {
        this.code = code.byteValue();
        this.message = message;
    }

    public Byte code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static EnvType valueOf(Byte code) {
        EnvType envType = envMap.get(code);
        if (envType != null) {
            return envType;
        }
        return UNKNOWN;
    }

    public boolean compare(Byte c) {
        return c != null && code.equals(c);
    }
}
