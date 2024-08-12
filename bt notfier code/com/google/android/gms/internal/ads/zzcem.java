/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzcez
 *  com.google.android.gms.internal.ads.zzcod
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcod;

final class zzcem
implements zzcez {
    private final String zza;
    private final Bundle zzb;

    zzcem(String string, Bundle bundle) {
        this.zza = string;
        this.zzb = bundle;
    }

    public final void zza(zzcod zzcod2) {
        zzcod2.zzd("am", this.zza, this.zzb);
    }
}
