/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.gms.internal.ads.zzanf
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.ads.zzanf;

final class zzane
extends Handler {
    final zzanf zza;

    zzane(zzanf zzanf2, Looper looper) {
        this.zza = zzanf2;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.zza.zzs(message);
    }
}
