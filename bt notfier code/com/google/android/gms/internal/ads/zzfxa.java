/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfty
 *  com.google.android.gms.internal.ads.zzfud
 *  com.google.android.gms.internal.ads.zzfwz
 *  com.google.android.gms.internal.ads.zzgco
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzfwz;
import com.google.android.gms.internal.ads.zzgco;
import java.security.GeneralSecurityException;

final class zzfxa
implements zzfty {
    private final zzfud<zzfty> zza;
    private final byte[] zzb = new byte[]{0};

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfxa(zzfud zzfud2, zzfwz zzfwz2) {
        this.zza = zzfud2;
    }

    public final byte[] zza(byte[] byArray) throws GeneralSecurityException {
        if (this.zza.zza().zzd() != 4) return zzgco.zza((byte[][])new byte[][]{this.zza.zza().zzb(), ((zzfty)this.zza.zza().zza()).zza(byArray)});
        return zzgco.zza((byte[][])new byte[][]{this.zza.zza().zzb(), ((zzfty)this.zza.zza().zza()).zza(zzgco.zza((byte[][])new byte[][]{byArray, this.zzb}))});
    }
}
