/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.google.android.gms.ads.internal.overlay.zzl
 */
package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;

final class zzedw
implements DialogInterface.OnCancelListener {
    private final zzl zza;

    zzedw(zzl zzl2) {
        this.zza = zzl2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface = this.zza;
        if (dialogInterface == null) return;
        dialogInterface.zzb();
    }
}
