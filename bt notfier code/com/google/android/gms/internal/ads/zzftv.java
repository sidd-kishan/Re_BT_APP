/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfua
 *  com.google.android.gms.internal.ads.zzfud
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfun
 *  com.google.android.gms.internal.ads.zzgar
 *  com.google.android.gms.internal.ads.zzgbb
 *  com.google.android.gms.internal.ads.zzgbc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfua;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfun;
import com.google.android.gms.internal.ads.zzgar;
import com.google.android.gms.internal.ads.zzgbb;
import com.google.android.gms.internal.ads.zzgbc;
import java.security.GeneralSecurityException;
import java.util.Iterator;

public final class zzftv {
    private final zzgbc zza;

    private zzftv(zzgbc zzgbc2) {
        this.zza = zzgbc2;
    }

    static final zzftv zza(zzgbc zzgbc2) throws GeneralSecurityException {
        if (zzgbc2 == null) throw new GeneralSecurityException("empty keyset");
        if (zzgbc2.zzd() <= 0) throw new GeneralSecurityException("empty keyset");
        return new zzftv(zzgbc2);
    }

    public final String toString() {
        return zzfun.zza((zzgbc)this.zza).toString();
    }

    public final <P> P zzb(Class<P> object) throws GeneralSecurityException {
        Class clazz = zzfum.zzn(object);
        if (clazz == null) {
            object = ((String)(object = String.valueOf(((Class)object).getName()))).length() != 0 ? "No wrapper found for ".concat((String)object) : new String("No wrapper found for ");
            throw new GeneralSecurityException((String)object);
        }
        zzfun.zzb((zzgbc)this.zza);
        zzfud zzfud2 = zzfud.zzb((Class)clazz);
        Iterator iterator = this.zza.zzc().iterator();
        while (iterator.hasNext()) {
            zzgbb zzgbb2 = (zzgbb)iterator.next();
            if (zzgbb2.zzf() != 3) continue;
            zzfua zzfua2 = zzfud2.zzd(zzfum.zzk((zzgar)zzgbb2.zzc(), (Class)clazz), zzgbb2);
            if (zzgbb2.zzd() != this.zza.zza()) continue;
            zzfud2.zzc(zzfua2);
        }
        return (P)zzfum.zzl((zzfud)zzfud2, (Class)object);
    }
}
