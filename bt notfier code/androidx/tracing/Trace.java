/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 *  androidx.tracing.TraceApi18Impl
 *  androidx.tracing.TraceApi29Impl
 */
package androidx.tracing;

import android.os.Build;
import android.util.Log;
import androidx.tracing.TraceApi18Impl;
import androidx.tracing.TraceApi29Impl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    public static void beginAsyncSection(String string, int n) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                TraceApi29Impl.beginAsyncSection((String)string, (int)n);
                return;
            }
        }
        catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        Trace.beginAsyncSectionFallback(string, n);
    }

    private static void beginAsyncSectionFallback(String string, int n) {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceBeginMethod.invoke(null, sTraceTagApp, string, n);
        }
        catch (Exception exception) {
            Trace.handleException("asyncTraceBegin", exception);
        }
    }

    public static void beginSection(String string) {
        if (Build.VERSION.SDK_INT < 18) return;
        TraceApi18Impl.beginSection((String)string);
    }

    public static void endAsyncSection(String string, int n) {
        try {
            if (sAsyncTraceEndMethod == null) {
                TraceApi29Impl.endAsyncSection((String)string, (int)n);
                return;
            }
        }
        catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        Trace.endAsyncSectionFallback(string, n);
    }

    private static void endAsyncSectionFallback(String string, int n) {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            sAsyncTraceEndMethod.invoke(null, sTraceTagApp, string, n);
        }
        catch (Exception exception) {
            Trace.handleException("asyncTraceEnd", exception);
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT < 18) return;
        TraceApi18Impl.endSection();
    }

    private static void handleException(String object, Exception exception) {
        if (exception instanceof InvocationTargetException) {
            object = exception.getCause();
            if (!(object instanceof RuntimeException)) throw new RuntimeException((Throwable)object);
            throw (RuntimeException)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call ");
        stringBuilder.append((String)object);
        stringBuilder.append(" via reflection");
        Log.v((String)TAG, (String)stringBuilder.toString(), (Throwable)exception);
    }

    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod != null) return Trace.isEnabledFallback();
            boolean bl = android.os.Trace.isEnabled();
            return bl;
        }
        catch (NoClassDefFoundError | NoSuchMethodError linkageError) {
        }
        return Trace.isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        if (Build.VERSION.SDK_INT < 18) return false;
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            boolean bl = (Boolean)sIsTagEnabledMethod.invoke(null, sTraceTagApp);
            return bl;
        }
        catch (Exception exception) {
            Trace.handleException("isTagEnabled", exception);
        }
        return false;
    }

    public static void setCounter(String string, int n) {
        try {
            if (sTraceCounterMethod == null) {
                TraceApi29Impl.setCounter((String)string, (int)n);
                return;
            }
        }
        catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        Trace.setCounterFallback(string, n);
    }

    private static void setCounterFallback(String string, int n) {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            sTraceCounterMethod.invoke(null, sTraceTagApp, string, n);
        }
        catch (Exception exception) {
            Trace.handleException("traceCounter", exception);
        }
    }
}
