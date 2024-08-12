/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgd
 *  com.google.android.gms.internal.ads.zzge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgd;
import com.google.android.gms.internal.ads.zzge;
import java.util.Comparator;

final class zzfw
implements Comparator {
    private final zzgd zza;

    zzfw(zzgd zzgd2) {
        this.zza = zzgd2;
    }

    public final int compare(Object object, Object object2) {
        zzgd zzgd2 = this.zza;
        int n = zzge.zza;
        return zzgd2.zza(object2) - zzgd2.zza(object);
    }
}
