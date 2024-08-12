/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcks
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzckt
implements Iterable<zzcks> {
    private final List<zzcks> zza = new ArrayList<zzcks>();

    @Override
    public final Iterator<zzcks> iterator() {
        return this.zza.iterator();
    }

    public final boolean zza(zzcjb object) {
        ArrayList<zzcks> arrayList = new ArrayList<zzcks>();
        for (zzcks zzcks2 : this) {
            if (zzcks2.zza != object) continue;
            arrayList.add(zzcks2);
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((zzcks)object.next()).zzb.zzm();
        }
        return true;
    }

    final zzcks zzb(zzcjb zzcjb2) {
        zzcks zzcks2;
        Iterator<zzcks> iterator = this.iterator();
        do {
            if (!iterator.hasNext()) return null;
            zzcks2 = iterator.next();
        } while (zzcks2.zza != zzcjb2);
        return zzcks2;
    }

    public final void zzc(zzcks zzcks2) {
        this.zza.add(zzcks2);
    }

    public final void zzd(zzcks zzcks2) {
        this.zza.remove(zzcks2);
    }
}
