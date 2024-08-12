/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfla;

public final class zzf
extends zzfla {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
            return;
        }
        catch (Exception exception) {
            zzt.zzg().zzk((Throwable)exception, "AdMobHandler.handleMessage");
            return;
        }
    }

    protected final void zza(Message message) {
        try {
            super.zza(message);
            return;
        }
        catch (Throwable throwable) {
            zzt.zzc();
            zzs.zzO((Context)zzt.zzg().zzq(), (Throwable)throwable);
            throw throwable;
        }
    }
}
