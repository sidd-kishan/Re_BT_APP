/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfmq
 *  com.google.android.gms.internal.ads.zzfnd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfnd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfmp
implements Iterator<Map.Entry> {
    final Iterator<Map.Entry> zza;
    @CheckForNull
    Collection zzb;
    final zzfmq zzc;

    zzfmp(zzfmq zzfmq2) {
        this.zzc = zzfmq2;
        this.zza = this.zzc.zza.entrySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final void remove() {
        boolean bl = this.zzb != null;
        zzflx.zzb((boolean)bl, (Object)"no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfnd zzfnd2 = this.zzc.zzb;
        zzfnd.zzf((zzfnd)zzfnd2, (int)(zzfnd.zze((zzfnd)zzfnd2) - this.zzb.size()));
        this.zzb.clear();
        this.zzb = null;
    }
}
