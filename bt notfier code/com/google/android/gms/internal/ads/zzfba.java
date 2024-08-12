/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcmc
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcni
 *  com.google.android.gms.internal.ads.zzcnv
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzfax
 *  com.google.android.gms.internal.ads.zzfay
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcmc;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzcnv;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzfax;
import com.google.android.gms.internal.ads.zzfay;
import com.google.android.gms.internal.ads.zzffu;

public final class zzfba {
    public static zzbpr<zzcml> zza(zzedq zzedq2, zzffu zzffu2, zzdio zzdio2) {
        return new zzfax(zzdio2, zzffu2, zzedq2);
    }

    public static <T extends zzcmc & zzcni & zzcnv> zzbpr<T> zzb(zzedq zzedq2, zzffu zzffu2) {
        return new zzfay(zzffu2, zzedq2);
    }
}
