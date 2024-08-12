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

final class zzao
implements DialogInterface.OnClickListener {
    private final zzav zza;

    zzao(zzav zzav2) {
        this.zza = zzav2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzb();
    }
}
