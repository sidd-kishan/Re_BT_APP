/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbka
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbka;

@Deprecated
public final class zzbjs {
    public static boolean zza(zzbka zzbka2, zzbjx zzbjx2, String ... stringArray) {
        if (zzbjx2 == null) {
            return false;
        }
        zzbka2.zzb(zzbjx2, zzt.zzj().elapsedRealtime(), stringArray);
        return true;
    }
}
