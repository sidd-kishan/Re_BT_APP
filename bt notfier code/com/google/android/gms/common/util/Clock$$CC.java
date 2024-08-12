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

public abstract class Clock$$CC {
    public static long currentThreadTimeMillis$$dflt$$(Clock clock) {
        return SystemClock.currentThreadTimeMillis();
    }
}
