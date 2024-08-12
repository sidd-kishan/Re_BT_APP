/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.internal.ads.zzawe
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzawe;

final class zzawb
extends BroadcastReceiver {
    final zzawe zza;

    zzawb(zzawe zzawe2) {
        this.zza = zzawe2;
    }

    public final void onReceive(Context context, Intent intent) {
        zzawe.zzc((zzawe)this.zza, (int)3);
    }
}
