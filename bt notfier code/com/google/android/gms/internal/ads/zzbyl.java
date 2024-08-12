/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.google.android.gms.internal.ads.zzbym
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.internal.ads.zzbym;

final class zzbyl
implements DialogInterface.OnClickListener {
    final zzbym zza;

    zzbyl(zzbym zzbym2) {
        this.zza = zzbym2;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.zzf("User canceled the download.");
    }
}
