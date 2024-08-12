/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.logging.HttpLoggingInterceptor$Logger$Companion
 *  okhttp3.logging.HttpLoggingInterceptor$Logger$Companion$DefaultLogger
 */
package okhttp3.logging;

import kotlin.Metadata;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2={"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "okhttp-logging-interceptor"}, k=1, mv={1, 5, 1}, xi=48)
public static interface HttpLoggingInterceptor.Logger {
    public static final Companion Companion = okhttp3.logging.HttpLoggingInterceptor$Logger$Companion.$$INSTANCE;
    public static final HttpLoggingInterceptor.Logger DEFAULT = (HttpLoggingInterceptor.Logger)new Companion.DefaultLogger();

    public void log(String var1);
}
