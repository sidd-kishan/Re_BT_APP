/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  com.google.android.gms.ads.internal.overlay.zzl
 */
package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Timer;
import java.util.TimerTask;

final class zzedx
extends TimerTask {
    final AlertDialog zza;
    final Timer zzb;
    final zzl zzc;

    zzedx(AlertDialog alertDialog, Timer timer, zzl zzl2) {
        this.zza = alertDialog;
        this.zzb = timer;
        this.zzc = zzl2;
    }

    @Override
    public final void run() {
        this.zza.dismiss();
        this.zzb.cancel();
        zzl zzl2 = this.zzc;
        if (zzl2 == null) return;
        zzl2.zzb();
    }
}
