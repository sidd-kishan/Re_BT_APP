/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.utils;

import com.google.gson.Gson;

public class JsonUtils {
    public static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
