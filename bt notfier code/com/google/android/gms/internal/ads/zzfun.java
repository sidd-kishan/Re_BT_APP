/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbb
 *  com.google.android.gms.internal.ads.zzgbc
 *  com.google.android.gms.internal.ads.zzgbe
 *  com.google.android.gms.internal.ads.zzgbg
 *  com.google.android.gms.internal.ads.zzgbh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbb;
import com.google.android.gms.internal.ads.zzgbc;
import com.google.android.gms.internal.ads.zzgbe;
import com.google.android.gms.internal.ads.zzgbg;
import com.google.android.gms.internal.ads.zzgbh;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

final class zzfun {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzgbh zza(zzgbc zzgbc2) {
        zzgbe zzgbe2 = zzgbh.zza();
        zzgbe2.zza(zzgbc2.zza());
        Iterator iterator = zzgbc2.zzc().iterator();
        while (iterator.hasNext()) {
            zzgbb zzgbb2 = (zzgbb)iterator.next();
            zzgbc2 = zzgbg.zza();
            zzgbc2.zza(zzgbb2.zzc().zza());
            zzgbc2.zzc(zzgbb2.zzf());
            zzgbc2.zzd(zzgbb2.zzg());
            zzgbc2.zzb(zzgbb2.zzd());
            zzgbe2.zzb((zzgbg)zzgbc2.zzah());
        }
        return (zzgbh)zzgbe2.zzah();
    }

    public static void zzb(zzgbc object) throws GeneralSecurityException {
        int n = object.zza();
        object = object.zzc().iterator();
        int n2 = 0;
        boolean bl = false;
        boolean bl2 = true;
        while (object.hasNext()) {
            zzgbb zzgbb2 = (zzgbb)object.next();
            if (zzgbb2.zzf() != 3) continue;
            if (!zzgbb2.zza()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", zzgbb2.zzd()));
            }
            if (zzgbb2.zzg() == 2) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", zzgbb2.zzd()));
            }
            if (zzgbb2.zzf() == 2) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", zzgbb2.zzd()));
            }
            boolean bl3 = bl;
            if (zzgbb2.zzd() == n) {
                if (bl) throw new GeneralSecurityException("keyset contains multiple primary keys");
                bl3 = true;
            }
            bl = zzgbb2.zzc().zzi() == 5;
            bl2 &= bl;
            ++n2;
            bl = bl3;
        }
        if (n2 != 0) {
            if (bl) return;
            if (!bl2) throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            return;
        }
        object = new GeneralSecurityException("keyset must contain at least one ENABLED key");
        throw object;
    }
}
