/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfor
 *  com.google.android.gms.internal.ads.zzfov
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfor;
import com.google.android.gms.internal.ads.zzfov;
import com.google.android.gms.internal.ads.zzfql;
import java.util.Iterator;

final class zzfoo
extends zzfql {
    final Iterator<? extends zzfoe> zza;
    Iterator zzb;
    final zzfor zzc;

    zzfoo(zzfor zzfor2) {
        this.zzc = zzfor2;
        this.zza = ((zzfoj)this.zzc.zzb.zzf()).zzt(0);
        this.zzb = zzfov.zza;
    }

    public final boolean hasNext() {
        if (this.zzb.hasNext()) return true;
        if (!this.zza.hasNext()) return false;
        return true;
    }

    public final Object next() {
        if (this.zzb.hasNext()) return this.zzb.next();
        this.zzb = this.zza.next().zza();
        return this.zzb.next();
    }
}
