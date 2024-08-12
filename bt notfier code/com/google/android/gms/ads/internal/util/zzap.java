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
import java.util.concurrent.atomic.AtomicInteger;

final class zzap
implements DialogInterface.OnClickListener {
    private final zzav zza;
    private final AtomicInteger zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    zzap(zzav zzav2, AtomicInteger atomicInteger, int n, int n2, int n3) {
        this.zza = zzav2;
        this.zzb = atomicInteger;
        this.zzc = n;
        this.zzd = n2;
        this.zze = n3;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzp(this.zzb, this.zzc, this.zzd, this.zze, dialogInterface, n);
    }
}
