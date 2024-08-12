/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcyj
 *  com.google.android.gms.internal.ads.zzewp
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcyj;
import com.google.android.gms.internal.ads.zzewp;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.Iterator;

final class zzewn
implements zzfrk {
    private final zzewp zza;
    private final zzfcl zzb;
    private final zzcyj zzc;

    zzewn(zzewp zzewp2, zzfcl zzfcl2, zzcyj zzcyj2) {
        this.zza = zzewp2;
        this.zzb = zzfcl2;
        this.zzc = zzcyj2;
    }

    public final zzfsm zza(Object object) {
        block3: {
            Object object2 = this.zzb;
            zzcyj zzcyj2 = this.zzc;
            object = (zzfal)object;
            ((zzfcl)object2).zzb = object;
            Iterator iterator = ((zzfal)object).zzb.zza.iterator();
            boolean bl = false;
            block0: while (true) {
                if (!iterator.hasNext()) {
                    if (!bl) break;
                    object = zzcyj2.zzd(zzfsd.zza((Object)object));
                    break block3;
                }
                object2 = ((zzezz)iterator.next()).zza.iterator();
                while (true) {
                    if (!object2.hasNext()) continue block0;
                    if (!((String)object2.next()).contains("FirstPartyRenderer")) break block0;
                    bl = true;
                }
                break;
            }
            object = zzfsd.zza(null);
        }
        return object;
    }
}
