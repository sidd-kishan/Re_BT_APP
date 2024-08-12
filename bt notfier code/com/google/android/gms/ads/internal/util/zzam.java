/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.google.android.gms.ads.internal.util.zzav
 */
package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.util.zzav;

final class zzam
implements DialogInterface.OnClickListener {
    private final zzav zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;

    zzam(zzav zzav2, int n, int n2, int n3, int n4, int n5) {
        this.zza = zzav2;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = n3;
        this.zze = n4;
        this.zzf = n5;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dialogInterface, n);
    }
}
