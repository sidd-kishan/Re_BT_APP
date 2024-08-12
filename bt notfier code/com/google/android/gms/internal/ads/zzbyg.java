/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.google.android.gms.internal.ads.zzbyh
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.internal.ads.zzbyh;

final class zzbyg
implements DialogInterface.OnClickListener {
    final zzbyh zza;

    zzbyg(zzbyh zzbyh2) {
        this.zza = zzbyh2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzf("Operation denied by user.");
    }
}
