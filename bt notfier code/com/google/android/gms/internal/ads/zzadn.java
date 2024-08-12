/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzado
 *  com.google.android.gms.internal.ads.zzadp
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzado;
import com.google.android.gms.internal.ads.zzadp;

final class zzadn
extends BroadcastReceiver
implements Runnable {
    final zzadp zza;
    private final zzado zzb;
    private final Handler zzc;

    public zzadn(zzadp zzadp2, Handler handler, zzado zzado2) {
        this.zza = zzadp2;
        this.zzc = handler;
        this.zzb = zzado2;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) return;
        this.zzc.post((Runnable)this);
    }

    @Override
    public final void run() {
    }
}
