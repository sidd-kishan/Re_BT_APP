/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzftn
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzgar
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftn;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzgar;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;

class zzfto<PrimitiveT, KeyProtoT extends zzghi>
implements zzftm<PrimitiveT> {
    private final zzftu<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzfto(zzftu<KeyProtoT> zzftu2, Class<PrimitiveT> clazz) {
        if (!zzftu2.zzf().contains(clazz) && !Void.class.equals(clazz)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzftu2.toString(), clazz.getName()));
        }
        this.zza = zzftu2;
        this.zzb = clazz;
    }

    private final PrimitiveT zzg(KeyProtoT KeyProtoT) throws GeneralSecurityException {
        if (Void.class.equals(this.zzb)) throw new GeneralSecurityException("Cannot create a primitive for Void");
        this.zza.zzd(KeyProtoT);
        return (PrimitiveT)this.zza.zze(KeyProtoT, this.zzb);
    }

    private final zzftn<?, KeyProtoT> zzh() {
        return new zzftn(this.zza.zzh());
    }

    public final PrimitiveT zza(zzgex object) throws GeneralSecurityException {
        try {
            object = this.zzg(this.zza.zzc((zzgex)object));
        }
        catch (zzggm zzggm2) {
            object = String.valueOf(this.zza.zza().getName());
            object = ((String)object).length() != 0 ? "Failures parsing proto of type ".concat((String)object) : new String("Failures parsing proto of type ");
            throw new GeneralSecurityException((String)object, zzggm2);
        }
        return (PrimitiveT)object;
    }

    public final PrimitiveT zzb(zzghi zzghi2) throws GeneralSecurityException {
        String string = String.valueOf(this.zza.zza().getName());
        string = string.length() != 0 ? "Expected proto of type ".concat(string) : new String("Expected proto of type ");
        if (!this.zza.zza().isInstance(zzghi2)) throw new GeneralSecurityException(string);
        return this.zzg(zzghi2);
    }

    public final zzghi zzc(zzgex object) throws GeneralSecurityException {
        try {
            object = this.zzh().zza((zzgex)object);
            return object;
        }
        catch (zzggm zzggm2) {
            object = String.valueOf(this.zza.zzh().zza().getName());
            object = ((String)object).length() != 0 ? "Failures parsing proto of type ".concat((String)object) : new String("Failures parsing proto of type ");
            throw new GeneralSecurityException((String)object, zzggm2);
        }
    }

    public final String zzd() {
        return this.zza.zzb();
    }

    public final Class<PrimitiveT> zze() {
        return this.zzb;
    }

    public final zzgar zzf(zzgex zzgex2) throws GeneralSecurityException {
        try {
            zzghi zzghi2 = this.zzh().zza(zzgex2);
            zzgex2 = zzgar.zzd();
            zzgex2.zza(this.zza.zzb());
            zzgex2.zzb(zzghi2.zzan());
            zzgex2.zzc(this.zza.zzi());
            zzgex2 = (zzgar)zzgex2.zzah();
            return zzgex2;
        }
        catch (zzggm zzggm2) {
            throw new GeneralSecurityException("Unexpected proto", zzggm2);
        }
    }
}
