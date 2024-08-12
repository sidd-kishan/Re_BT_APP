/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class zzfla
extends Handler {
    public zzfla() {
    }

    public zzfla(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        this.zza(message);
    }

    protected void zza(Message message) {
        super.dispatchMessage(message);
    }
}
