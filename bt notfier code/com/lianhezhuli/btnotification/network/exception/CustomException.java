/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ParseException
 *  com.lianhezhuli.btnotification.network.exception.ApiException
 *  org.json.JSONException
 */
package com.lianhezhuli.btnotification.network.exception;

import android.net.ParseException;
import com.google.gson.JsonParseException;
import com.lianhezhuli.btnotification.network.exception.ApiException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.json.JSONException;

public class CustomException {
    public static final int HTTP_ERROR = 1003;
    public static final String NETWORK_ERROR = "1002";
    public static final String PARSE_ERROR = "1001";
    public static final String UNKNOWN = "1000";

    public static ApiException handleException(Throwable throwable) {
        if (throwable instanceof JsonParseException) return new ApiException(PARSE_ERROR, throwable.getMessage(), "");
        if (throwable instanceof JSONException) return new ApiException(PARSE_ERROR, throwable.getMessage(), "");
        if (throwable instanceof ParseException) {
            return new ApiException(PARSE_ERROR, throwable.getMessage(), "");
        }
        if (throwable instanceof ConnectException) {
            return new ApiException(NETWORK_ERROR, throwable.getMessage(), "");
        }
        if (throwable instanceof UnknownHostException) return new ApiException(NETWORK_ERROR, throwable.getMessage(), "");
        if (throwable instanceof SocketTimeoutException) {
            return new ApiException(NETWORK_ERROR, throwable.getMessage(), "");
        }
        if (!(throwable instanceof ApiException)) return new ApiException(UNKNOWN, throwable.getMessage(), "");
        return (ApiException)throwable;
    }
}
