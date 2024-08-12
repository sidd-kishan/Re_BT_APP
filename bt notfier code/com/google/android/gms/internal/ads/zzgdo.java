/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdb
 *  com.google.android.gms.internal.ads.zzgdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdb;
import com.google.android.gms.internal.ads.zzgdp;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;

final class zzgdo
extends ThreadLocal<Mac> {
    final zzgdp zza;

    zzgdo(zzgdp zzgdp2) {
        this.zza = zzgdp2;
    }

    protected final Mac zza() {
        try {
            Mac mac = (Mac)zzgdb.zzb.zzb(zzgdp.zzb((zzgdp)this.zza));
            mac.init(zzgdp.zzc((zzgdp)this.zza));
            return mac;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new IllegalStateException(generalSecurityException);
        }
    }
}
