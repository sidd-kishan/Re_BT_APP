/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsu;

final class zzbss
implements Predicate {
    private final zzbpr zza;

    zzbss(zzbpr zzbpr2) {
        this.zza = zzbpr2;
    }

    public final boolean apply(Object object) {
        zzbpr zzbpr2 = this.zza;
        if (!((object = (zzbpr)object) instanceof zzbsu)) return false;
        if (!zzbsu.zzb((zzbsu)((zzbsu)object)).equals(zzbpr2)) return false;
        return true;
    }
}
