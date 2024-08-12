/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class zzftu<KeyProtoT extends zzghi> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzftt<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    @SafeVarargs
    protected zzftu(Class<KeyProtoT> zzftt2, zzftt<?, KeyProtoT> ... zzfttArray) {
        this.zza = zzftt2;
        HashMap<Class, Class<KeyProtoT>> hashMap = new HashMap<Class, Class<KeyProtoT>>();
        int n = 0;
        while (true) {
            if (n > 0) {
                this.zzc = zzfttArray[0].zza();
                this.zzb = Collections.unmodifiableMap(hashMap);
                return;
            }
            zzftt2 = zzfttArray[n];
            if (hashMap.containsKey(zzftt2.zza())) {
                if ((zzftt2 = String.valueOf(zzftt2.zza().getCanonicalName())).length() != 0) {
                    zzftt2 = "KeyTypeManager constructed with duplicate factories for primitive ".concat((String)zzftt2);
                    break;
                }
                zzftt2 = new String("KeyTypeManager constructed with duplicate factories for primitive ");
                break;
            }
            hashMap.put(zzftt2.zza(), (Class<KeyProtoT>)zzftt2);
            ++n;
        }
        throw new IllegalArgumentException((String)zzftt2);
    }

    public final Class<KeyProtoT> zza() {
        return this.zza;
    }

    public abstract String zzb();

    public abstract KeyProtoT zzc(zzgex var1) throws zzggm;

    public abstract void zzd(KeyProtoT var1) throws GeneralSecurityException;

    public final <P> P zze(KeyProtoT object, Class<P> object2) throws GeneralSecurityException {
        zzftt<?, KeyProtoT> zzftt2 = this.zzb.get(object2);
        if (zzftt2 != null) {
            return (P)zzftt2.zzb(object);
        }
        object2 = ((Class)object2).getCanonicalName();
        object = new StringBuilder(String.valueOf(object2).length() + 41);
        ((StringBuilder)object).append("Requested primitive class ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" not supported.");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public final Set<Class<?>> zzf() {
        return this.zzb.keySet();
    }

    final Class<?> zzg() {
        return this.zzc;
    }

    public zzfts<?, KeyProtoT> zzh() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract int zzi();

    public int zzj() {
        return 1;
    }
}
