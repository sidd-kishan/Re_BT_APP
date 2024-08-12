/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbyh
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbyh;

final class zzbyf
implements DialogInterface.OnClickListener {
    final zzbyh zza;

    zzbyf(zzbyh zzbyh2) {
        this.zza = zzbyh2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        dialogInterface = this.zza.zzc();
        zzt.zzc();
        zzs.zzP((Context)zzbyh.zza((zzbyh)this.zza), (Intent)dialogInterface);
    }
}
