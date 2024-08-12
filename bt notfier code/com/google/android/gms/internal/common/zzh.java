/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

public class zzh
extends Handler {
    public zzh() {
    }

    public zzh(Looper looper) {
        super(looper);
    }

    public zzh(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
