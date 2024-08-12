/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftj
 *  com.google.android.gms.internal.ads.zzfud
 *  com.google.android.gms.internal.ads.zzgco
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftj;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzgco;
import java.security.GeneralSecurityException;

final class zzfwc
implements zzftj {
    private final zzfud<zzftj> zza;

    public zzfwc(zzfud<zzftj> zzfud2) {
        this.zza = zzfud2;
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        return zzgco.zza((byte[][])new byte[][]{this.zza.zza().zzb(), ((zzftj)this.zza.zza().zza()).zza(byArray, byArray2)});
    }
}
