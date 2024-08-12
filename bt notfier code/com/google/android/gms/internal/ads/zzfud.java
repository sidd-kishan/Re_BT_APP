/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfti
 *  com.google.android.gms.internal.ads.zzfua
 *  com.google.android.gms.internal.ads.zzfuc
 *  com.google.android.gms.internal.ads.zzgbb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfti;
import com.google.android.gms.internal.ads.zzfua;
import com.google.android.gms.internal.ads.zzfuc;
import com.google.android.gms.internal.ads.zzgbb;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzfud<P> {
    private final ConcurrentMap<zzfuc, List<zzfua<P>>> zza = new ConcurrentHashMap<zzfuc, List<zzfua<P>>>();
    private zzfua<P> zzb;
    private final Class<P> zzc;

    private zzfud(Class<P> clazz) {
        this.zzc = clazz;
    }

    public static <P> zzfud<P> zzb(Class<P> clazz) {
        return new zzfud<P>(clazz);
    }

    public final zzfua<P> zza() {
        return this.zzb;
    }

    public final void zzc(zzfua<P> zzfua2) {
        if (zzfua2.zzc() != 3) throw new IllegalArgumentException("the primary entry has to be ENABLED");
        Object object = zzfua2.zzb();
        List list = (List)this.zza.get(new zzfuc(object, null));
        object = list;
        if (list == null) {
            object = Collections.emptyList();
        }
        if (object.isEmpty()) throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        this.zzb = zzfua2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final zzfua<P> zzd(P var1_1, zzgbb var2_2) throws GeneralSecurityException {
        block3: {
            block2: {
                if (var2_2.zzf() != 3) throw new GeneralSecurityException("only ENABLED key is allowed");
                var3_3 = var2_2.zzg() - 2;
                if (var3_3 == 1) break block2;
                if (var3_3 == 2) ** GOTO lbl9
                if (var3_3 == 3) {
                    var4_4 = zzfti.zza;
                } else {
                    if (var3_3 != 4) throw new GeneralSecurityException("unknown output prefix type");
lbl9:
                    // 2 sources

                    var4_4 = ByteBuffer.allocate(5).put((byte)0).putInt(var2_2.zzd()).array();
                }
                break block3;
            }
            var4_4 = ByteBuffer.allocate(5).put((byte)1).putInt(var2_2.zzd()).array();
        }
        var1_1 /* !! */  = new zzfua(var1_1 /* !! */ , (byte[])var4_4, var2_2.zzf(), var2_2.zzg(), var2_2.zzd());
        var4_4 = new ArrayList<E>();
        var4_4.add(var1_1 /* !! */ );
        var2_2 = new zzfuc(var1_1 /* !! */ .zzb(), null);
        var4_4 = this.zza.put((zzfuc)var2_2, Collections.unmodifiableList(var4_4));
        if (var4_4 == null) return var1_1 /* !! */ ;
        var5_5 = new ArrayList<P>();
        var5_5.addAll((Collection<P>)var4_4);
        var5_5.add(var1_1 /* !! */ );
        this.zza.put((zzfuc)var2_2, Collections.unmodifiableList(var5_5));
        return var1_1 /* !! */ ;
    }

    public final Class<P> zze() {
        return this.zzc;
    }
}
