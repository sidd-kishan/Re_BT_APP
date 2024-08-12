/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.common.util.Clock
 */
package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;

public class DefaultClock
implements Clock {
    private static final DefaultClock zza = new DefaultClock();

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zza;
    }

    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime() {
        return System.nanoTime();
    }
}
