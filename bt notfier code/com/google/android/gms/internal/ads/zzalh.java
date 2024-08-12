/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.google.android.gms.internal.ads.zzalm
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.ads.zzalm;

final class zzalh
implements Handler.Callback {
    private final zzalm zza;

    zzalh(zzalm zzalm2) {
        this.zza = zzalm2;
    }

    public final boolean handleMessage(Message message) {
        this.zza.zzg(message);
        return true;
    }
}
