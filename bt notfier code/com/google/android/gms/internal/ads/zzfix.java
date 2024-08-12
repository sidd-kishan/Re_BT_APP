/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfjb
 *  com.google.android.gms.tasks.OnFailureListener
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.tasks.OnFailureListener;

final class zzfix
implements OnFailureListener {
    private final zzfjb zza;

    zzfix(zzfjb zzfjb2) {
        this.zza = zzfjb2;
    }

    public final void onFailure(Exception exception) {
        this.zza.zzd(exception);
    }
}
