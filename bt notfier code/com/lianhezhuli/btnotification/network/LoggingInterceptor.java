/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.orhanobut.logger.Logger
 *  okhttp3.FormBody
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 */
package com.lianhezhuli.btnotification.network;

import android.content.Context;
import android.os.Build;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.utils.Utils;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggingInterceptor
implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("BtNotification/");
        ((StringBuilder)serializable).append(Utils.getVersion((Context)MApplication.getInstance()));
        ((StringBuilder)serializable).append("(");
        ((StringBuilder)serializable).append(Build.MODEL);
        ((StringBuilder)serializable).append("; Android ");
        ((StringBuilder)serializable).append(Build.VERSION.RELEASE);
        ((StringBuilder)serializable).append(")");
        Object object = builder.addHeader("User-Agent", ((StringBuilder)serializable).toString()).build();
        long l = System.nanoTime();
        if ("POST".equals(object.method())) {
            serializable = new StringBuilder();
            if (object.body() instanceof FormBody) {
                builder = (FormBody)object.body();
                for (int i = 0; i < builder.size(); ++i) {
                    ((StringBuilder)serializable).append(builder.encodedName(i));
                    ((StringBuilder)serializable).append("=");
                    ((StringBuilder)serializable).append(builder.encodedValue(i));
                    ((StringBuilder)serializable).append(",");
                }
                ((StringBuilder)serializable).delete(((StringBuilder)serializable).length() - 1, ((StringBuilder)serializable).length());
                Logger.w((String)String.format("\u53d1\u9001\u8bf7\u6c42 %s on %s %n%s %nRequestParams:{%s}", object.url(), chain.connection(), object.headers(), ((StringBuilder)serializable).toString()), (Object[])new Object[0]);
            }
        } else {
            Logger.w((String)String.format("\u53d1\u9001\u8bf7\u6c42 %s on %s%n%s", object.url(), chain.connection(), object.headers()), (Object[])new Object[0]);
        }
        chain = chain.proceed(object);
        long l2 = System.nanoTime();
        object = chain.peekBody(0x100000L);
        serializable = Locale.CHINA;
        builder = chain.request().url();
        object = object.string();
        double d = l2 - l;
        Double.isNaN(d);
        Logger.w((String)String.format((Locale)serializable, "\u63a5\u6536\u54cd\u5e94: [%s] %n\u8fd4\u56dejson:\u3010%s\u3011 %.1fms %n%s", builder, object, d / 1000000.0, chain.headers()), (Object[])new Object[0]);
        return chain;
    }
}
