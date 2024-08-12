/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.EventListener$Factory
 *  okhttp3.logging.HttpLoggingInterceptor$Logger
 *  okhttp3.logging.LoggingEventListener
 */
package okhttp3.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.LoggingEventListener;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lokhttp3/logging/LoggingEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp-logging-interceptor"}, k=1, mv={1, 5, 1}, xi=48)
public static class LoggingEventListener.Factory
implements EventListener.Factory {
    private final HttpLoggingInterceptor.Logger logger;

    public LoggingEventListener.Factory() {
        this(null, 1, null);
    }

    public LoggingEventListener.Factory(HttpLoggingInterceptor.Logger logger) {
        Intrinsics.checkNotNullParameter((Object)logger, (String)"logger");
        this.logger = logger;
    }

    public /* synthetic */ LoggingEventListener.Factory(HttpLoggingInterceptor.Logger logger, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            logger = HttpLoggingInterceptor.Logger.DEFAULT;
        }
        this(logger);
    }

    public EventListener create(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        return (EventListener)new LoggingEventListener(this.logger, null);
    }
}
