/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 */
package androidx.tracing;

import android.os.Trace;

final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String string, int n) {
        Trace.beginAsyncSection((String)string, (int)n);
    }

    public static void endAsyncSection(String string, int n) {
        Trace.endAsyncSection((String)string, (int)n);
    }

    public static void setCounter(String string, int n) {
        Trace.setCounter((String)string, (long)n);
    }
}
