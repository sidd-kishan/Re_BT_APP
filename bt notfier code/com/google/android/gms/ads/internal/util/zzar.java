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

final class zzar
implements DialogInterface.OnClickListener {
    private final zzav zza;
    private final String zzb;

    zzar(zzav zzav2, String string) {
        this.zza = zzav2;
        this.zzb = string;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzo(this.zzb, dialogInterface, n);
    }
}
