/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

public abstract class zzfts<KeyFormatProtoT extends zzghi, KeyT> {
    private final Class<KeyFormatProtoT> zza;

    public zzfts(Class<KeyFormatProtoT> clazz) {
        this.zza = clazz;
    }

    public final Class<KeyFormatProtoT> zza() {
        return this.zza;
    }

    public abstract void zzb(KeyFormatProtoT var1) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzc(zzgex var1) throws zzggm;

    public abstract KeyT zzd(KeyFormatProtoT var1) throws GeneralSecurityException;

    public Map<String, zzftr<KeyFormatProtoT>> zze() throws GeneralSecurityException {
        return Collections.emptyMap();
    }
}
