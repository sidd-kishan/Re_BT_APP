/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.ads.internal.util.zzq
 *  com.google.android.gms.ads.internal.util.zzs
 */
package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.ads.internal.util.zzs;

final class zzr
extends BroadcastReceiver {
    final zzs zza;

    /* synthetic */ zzr(zzs zzs2, zzq zzq2) {
        this.zza = zzs2;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzs.zzb((zzs)this.zza, (boolean)true);
            return;
        }
        if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) return;
        zzs.zzb((zzs)this.zza, (boolean)false);
    }
}
