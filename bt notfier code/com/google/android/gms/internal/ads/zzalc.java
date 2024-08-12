/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseBooleanArray
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzale
 */
package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzale;

public final class zzalc {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzalc zza(int n) {
        zzakt.zzd((boolean)(this.zzb ^ true));
        this.zza.append(n, true);
        return this;
    }

    public final zzale zzb() {
        zzakt.zzd((boolean)(this.zzb ^ true));
        this.zzb = true;
        return new zzale(this.zza, null);
    }
}
