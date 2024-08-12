/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.internal.ads.zzaby
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzaby;

final class zzabx
extends BroadcastReceiver {
    final zzaby zza;

    zzabx(zzaby zzaby2) {
        this.zza = zzaby2;
    }

    public final void onReceive(Context context, Intent intent) {
        zzaby.zzd((zzaby)this.zza);
    }
}
