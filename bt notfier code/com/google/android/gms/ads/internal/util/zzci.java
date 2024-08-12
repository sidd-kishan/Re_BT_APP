/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.ads.internal.util.zzcj
 */
package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzcj;

final class zzci
extends BroadcastReceiver {
    final zzcj zza;

    zzci(zzcj zzcj2) {
        this.zza = zzcj2;
    }

    public final void onReceive(Context context, Intent intent) {
        zzcj.zzd((zzcj)this.zza, (Context)context, (Intent)intent);
    }
}
