/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsw;
import java.util.concurrent.TimeoutException;

final class zzfsx
extends TimeoutException {
    /* synthetic */ zzfsx(String string, zzfsw zzfsw2) {
        super(string);
    }

    @Override
    public final Throwable fillInStackTrace() {
        synchronized (this) {
            this.setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }
}
