/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzctj
 *  com.google.android.gms.internal.ads.zzctl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzctj;
import com.google.android.gms.internal.ads.zzctl;
import java.util.Map;

final class zzctk
implements zzbpr<Object> {
    final zzctl zza;

    zzctk(zzctl zzctl2) {
        this.zza = zzctl2;
    }

    public final void zza(Object object, Map<String, String> map) {
        if (!zzctl.zzg((zzctl)this.zza, map)) {
            return;
        }
        zzctl.zza((zzctl)this.zza).execute((Runnable)new zzctj(this));
    }
}
