/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.internal.ads.zzaig
 *  com.google.android.gms.internal.ads.zzaih
 *  com.google.android.gms.internal.ads.zzaij
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzaig;
import com.google.android.gms.internal.ads.zzaih;
import com.google.android.gms.internal.ads.zzaij;

final class zzaii
extends BroadcastReceiver {
    final zzaij zza;

    /* synthetic */ zzaii(zzaij zzaij2, zzaig zzaig2) {
        this.zza = zzaij2;
    }

    public final void onReceive(Context context, Intent intent) {
        zzaij.zza((zzaij)this.zza).post((Runnable)new zzaih(this.zza));
    }
}
