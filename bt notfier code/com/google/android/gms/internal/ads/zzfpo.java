/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmj
 *  com.google.android.gms.internal.ads.zzfoy
 *  com.google.android.gms.internal.ads.zzfpm
 *  com.google.android.gms.internal.ads.zzfpn
 *  com.google.android.gms.internal.ads.zzfpp
 *  com.google.android.gms.internal.ads.zzfps
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmj;
import com.google.android.gms.internal.ads.zzfoy;
import com.google.android.gms.internal.ads.zzfpm;
import com.google.android.gms.internal.ads.zzfpn;
import com.google.android.gms.internal.ads.zzfpp;
import com.google.android.gms.internal.ads.zzfps;

final class zzfpo
extends zzfpn {
    final zzfpp zza;

    zzfpo(zzfpp zzfpp2, int n) {
        this.zza = zzfpp2;
    }

    public final <K, V> zzfoy<K, V> zza() {
        return new zzfps(this.zza.zza(), (zzfmj)new zzfpm(2));
    }
}
