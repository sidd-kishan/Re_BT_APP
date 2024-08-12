/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.google.android.gms.ads.internal.util.zzav
 */
package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.util.zzav;

final class zzaq
implements DialogInterface.OnCancelListener {
    private final zzav zza;

    zzaq(zzav zzav2) {
        this.zza = zzav2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzb();
    }
}
