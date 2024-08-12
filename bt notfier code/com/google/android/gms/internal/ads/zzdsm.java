/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.gms.internal.ads.zzdsr
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzdsr;

final class zzdsm
implements View.OnClickListener {
    private final zzdsr zza;

    zzdsm(zzdsr zzdsr2) {
        this.zza = zzdsr2;
    }

    public final void onClick(View view) {
        this.zza.zzd(view);
    }
}
