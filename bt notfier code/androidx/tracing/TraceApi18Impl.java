/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 */
package androidx.tracing;

import android.os.Trace;

final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(String string) {
        Trace.beginSection((String)string);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
