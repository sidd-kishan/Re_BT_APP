/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatt
 *  com.google.android.gms.internal.ads.zzatv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzatv;

public abstract class zzatu {
    private zzatt zza;

    public abstract zzatv zzd(zzans[] var1, zzatg var2) throws zzamy;

    public abstract void zze(Object var1);

    public final void zzf(zzatt zzatt2) {
        this.zza = zzatt2;
    }

    protected final void zzg() {
        zzatt zzatt2 = this.zza;
        if (zzatt2 == null) return;
        zzatt2.zzk();
    }
}
