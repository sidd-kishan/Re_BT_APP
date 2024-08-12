/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfud
 *  com.google.android.gms.internal.ads.zzfup
 *  com.google.android.gms.internal.ads.zzgco
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzfup;
import com.google.android.gms.internal.ads.zzgco;
import java.security.GeneralSecurityException;

final class zzfuq
implements zzftg {
    private final zzfud<zzftg> zza;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfuq(zzfud zzfud2, zzfup zzfup2) {
        this.zza = zzfud2;
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        return zzgco.zza((byte[][])new byte[][]{this.zza.zza().zzb(), ((zzftg)this.zza.zza().zza()).zza(byArray, byArray2)});
    }
}
