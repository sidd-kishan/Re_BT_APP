/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class zzfgr {
    private static final zzfgr zza = new zzfgr();
    private final ArrayList<zzfgg> zzb = new ArrayList();
    private final ArrayList<zzfgg> zzc = new ArrayList();

    private zzfgr() {
    }

    public static zzfgr zza() {
        return zza;
    }

    public final void zzb(zzfgg zzfgg2) {
        this.zzb.add(zzfgg2);
    }

    public final void zzc(zzfgg zzfgg2) {
        boolean bl = this.zzg();
        this.zzc.add(zzfgg2);
        if (bl) return;
        zzfgy.zza().zzc();
    }

    public final void zzd(zzfgg zzfgg2) {
        boolean bl = this.zzg();
        this.zzb.remove(zzfgg2);
        this.zzc.remove(zzfgg2);
        if (!bl) return;
        if (this.zzg()) return;
        zzfgy.zza().zzd();
    }

    public final Collection<zzfgg> zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection<zzfgg> zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        if (this.zzc.size() <= 0) return false;
        return true;
    }
}
