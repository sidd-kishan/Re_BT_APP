/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class Asserts {
    private Asserts() {
        throw new AssertionError((Object)"Uninstantiable");
    }

    public static void checkMainThread(String string) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String string2 = String.valueOf(Thread.currentThread());
        String string3 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 57 + String.valueOf(string3).length());
        stringBuilder.append("checkMainThread: current thread ");
        stringBuilder.append(string2);
        stringBuilder.append(" IS NOT the main thread ");
        stringBuilder.append(string3);
        stringBuilder.append("!");
        Log.e((String)"Asserts", (String)stringBuilder.toString());
        throw new IllegalStateException(string);
    }

    public static void checkNotMainThread(String string) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String string2 = String.valueOf(Thread.currentThread());
        String string3 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 56 + String.valueOf(string3).length());
        stringBuilder.append("checkNotMainThread: current thread ");
        stringBuilder.append(string2);
        stringBuilder.append(" IS the main thread ");
        stringBuilder.append(string3);
        stringBuilder.append("!");
        Log.e((String)"Asserts", (String)stringBuilder.toString());
        throw new IllegalStateException(string);
    }

    public static void checkNotNull(Object object) {
        if (object == null) throw new IllegalArgumentException("null reference");
    }

    public static void checkNotNull(Object object, Object object2) {
        if (object == null) throw new IllegalArgumentException(String.valueOf(object2));
    }

    public static void checkNull(Object object) {
        if (object != null) throw new IllegalArgumentException("non-null reference");
    }

    public static void checkState(boolean bl) {
        if (!bl) throw new IllegalStateException();
    }

    public static void checkState(boolean bl, Object object) {
        if (!bl) throw new IllegalStateException(String.valueOf(object));
    }
}
