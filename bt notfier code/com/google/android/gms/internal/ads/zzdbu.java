/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdbt
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdbt;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import java.util.Set;

public final class zzdbu
extends zzdgm<zzdbw> {
    private boolean zzb = false;

    public zzdbu(Set<zzdih<zzdbw>> set) {
        super(set);
    }

    public final void zza() {
        synchronized (this) {
            if (this.zzb) return;
            this.zzk(zzdbt.zza);
            this.zzb = true;
            return;
        }
    }
}
