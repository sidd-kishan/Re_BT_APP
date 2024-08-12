/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.OkHttpClient
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.http2.Http2
 *  okhttp3.internal.platform.android.AndroidLogHandler
 */
package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.platform.android.AndroidLogHandler;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u00a2\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lokhttp3/internal/platform/android/AndroidLog;", "", "()V", "MAX_LOG_LENGTH", "", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", "", "", "androidLog", "", "loggerName", "logLevel", "message", "t", "", "androidLog$okhttp", "enable", "enableLogging", "logger", "tag", "loggerTag", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidLog {
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet();
    private static final Map<String, String> knownLoggers;

    static {
        Object object = new LinkedHashMap();
        Object object2 = OkHttpClient.class.getPackage();
        object2 = object2 == null ? null : ((Package)object2).getName();
        if (object2 != null) {
            ((Map)object).put(object2, "OkHttp");
        }
        object2 = (Map)object;
        object = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"OkHttpClient::class.java.name");
        object2.put(object, "okhttp.OkHttpClient");
        object = Http2.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Http2::class.java.name");
        object2.put(object, "okhttp.Http2");
        object = TaskRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"TaskRunner::class.java.name");
        object2.put(object, "okhttp.TaskRunner");
        object2.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap((Map)object2);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String object, String string) {
        Logger logger = Logger.getLogger((String)object);
        if (!configuredLoggers.add(logger)) return;
        logger.setUseParentHandlers(false);
        object = Log.isLoggable((String)string, (int)3) ? Level.FINE : (Log.isLoggable((String)string, (int)4) ? Level.INFO : Level.WARNING);
        logger.setLevel((Level)object);
        logger.addHandler((Handler)AndroidLogHandler.INSTANCE);
    }

    private final String loggerTag(String string) {
        String string2;
        String string3 = string2 = knownLoggers.get(string);
        if (string2 != null) return string3;
        string3 = StringsKt.take((String)string, (int)23);
        return string3;
    }

    public final void androidLog$okhttp(String charSequence, int n, String string, Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"loggerName");
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        String string2 = this.loggerTag((String)charSequence);
        if (!Log.isLoggable((String)string2, (int)n)) return;
        charSequence = string;
        if (throwable != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append('\n');
            ((StringBuilder)charSequence).append((Object)Log.getStackTraceString((Throwable)throwable));
            charSequence = ((StringBuilder)charSequence).toString();
        }
        int n2 = 0;
        int n3 = ((String)charSequence).length();
        block0: while (n2 < n3) {
            int n4 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'\n', (int)n2, (boolean)false, (int)4, null);
            if (n4 == -1) {
                n4 = n3;
            }
            while (true) {
                int n5 = Math.min(n4, n2 + 4000);
                if (charSequence == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                string = ((String)charSequence).substring(n2, n5);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                Log.println((int)n, (String)string2, (String)string);
                if (n5 >= n4) {
                    n2 = n5 + 1;
                    continue block0;
                }
                n2 = n5;
            }
            break;
        }
        return;
    }

    public final void enable() {
        Iterator<Map.Entry<String, String>> iterator = knownLoggers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            this.enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
