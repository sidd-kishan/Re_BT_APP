/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzedb
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzfrz;

final class zzeda
implements zzfrz<Bundle> {
    final boolean zza;
    final zzedb zzb;

    zzeda(zzedb zzedb2, boolean bl) {
        this.zzb = zzedb2;
        this.zza = bl;
    }

    public final void zza(Throwable throwable) {
        zze.zzf((String)"Failed to get signals bundle");
    }
}
