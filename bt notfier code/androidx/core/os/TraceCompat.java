/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        if (Build.VERSION.SDK_INT < 18) return;
        if (Build.VERSION.SDK_INT >= 29) return;
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        }
        catch (Exception exception) {
            Log.i((String)TAG, (String)"Unable to initialize via reflection.", (Throwable)exception);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(String string, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.beginAsyncSection((String)string, (int)n);
        } else {
            if (Build.VERSION.SDK_INT < 18) return;
            try {
                sAsyncTraceBeginMethod.invoke(null, sTraceTagApp, string, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(String string) {
        if (Build.VERSION.SDK_INT < 18) return;
        Trace.beginSection((String)string);
    }

    public static void endAsyncSection(String string, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection((String)string, (int)n);
        } else {
            if (Build.VERSION.SDK_INT < 18) return;
            try {
                sAsyncTraceEndMethod.invoke(null, sTraceTagApp, string, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) return;
        Trace.endSection();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Trace.isEnabled();
        }
        if (Build.VERSION.SDK_INT < 18) return false;
        try {
            boolean bl = (Boolean)sIsTagEnabledMethod.invoke(null, sTraceTagApp);
            return bl;
        }
        catch (Exception exception) {
            Log.v((String)TAG, (String)"Unable to invoke isTagEnabled() via reflection.");
        }
        return false;
    }

    public static void setCounter(String string, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.setCounter((String)string, (long)n);
        } else {
            if (Build.VERSION.SDK_INT < 18) return;
            try {
                sTraceCounterMethod.invoke(null, sTraceTagApp, string, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}
