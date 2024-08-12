/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.Platform
 *  okhttp3.logging.HttpLoggingInterceptor$Logger
 */
package okhttp3.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "okhttp-logging-interceptor"}, k=1, mv={1, 5, 1}, xi=48)
private static final class HttpLoggingInterceptor.Logger.Companion.DefaultLogger
implements HttpLoggingInterceptor.Logger {
    public void log(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Platform.log$default((Platform)Platform.Companion.get(), (String)string, (int)0, null, (int)6, null);
    }
}
