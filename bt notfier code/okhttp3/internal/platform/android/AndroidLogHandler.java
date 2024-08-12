/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.android.AndroidLog
 *  okhttp3.internal.platform.android.AndroidLogKt
 */
package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidLogKt;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "()V", "close", "", "flush", "publish", "record", "Ljava/util/logging/LogRecord;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidLogHandler
extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    public void publish(LogRecord logRecord) {
        Intrinsics.checkNotNullParameter((Object)logRecord, (String)"record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String string = logRecord.getLoggerName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"record.loggerName");
        int n = AndroidLogKt.access$getAndroidLevel((LogRecord)logRecord);
        String string2 = logRecord.getMessage();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"record.message");
        androidLog.androidLog$okhttp(string, n, string2, logRecord.getThrown());
    }
}
