/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftk
 *  com.google.android.gms.internal.ads.zzgct
 *  com.google.android.gms.internal.ads.zzgcw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftk;
import com.google.android.gms.internal.ads.zzgct;
import com.google.android.gms.internal.ads.zzgcw;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzgcu
implements zzftk {
    private final ECPrivateKey zza;
    private final zzgcw zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzgct zze;

    public zzgcu(ECPrivateKey eCPrivateKey, byte[] byArray, String string, int n, zzgct zzgct2) throws GeneralSecurityException {
        this.zza = eCPrivateKey;
        this.zzb = new zzgcw(eCPrivateKey);
        this.zzd = byArray;
        this.zzc = string;
        this.zze = zzgct2;
    }
}
