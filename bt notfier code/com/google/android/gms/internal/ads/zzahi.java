/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzahg
 *  com.google.android.gms.internal.ads.zzahh
 *  com.google.android.gms.internal.ads.zzahm
 *  com.google.android.gms.internal.ads.zzale
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzahg;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzahm;
import com.google.android.gms.internal.ads.zzale;

public final class zzahi {
    public static final zzahi zza = new zzahh().zze();
    public static final zzadw<zzahi> zzb = zzahg.zza;
    private final zzale zzc;

    /* synthetic */ zzahi(zzale zzale2, zzahm zzahm2) {
        this.zzc = zzale2;
    }

    static /* synthetic */ zzale zza(zzahi zzahi2) {
        return zzahi2.zzc;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzahi)) {
            return false;
        }
        object = (zzahi)object;
        return this.zzc.equals((Object)((zzahi)object).zzc);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }
}
