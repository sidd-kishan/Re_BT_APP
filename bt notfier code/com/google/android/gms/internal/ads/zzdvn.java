/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzdvp
 *  com.google.android.gms.internal.ads.zzffk
 *  com.google.android.gms.internal.ads.zzffm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzdvp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzffm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdvn
extends zzdvp {
    private final zzffk zzf;

    public zzdvn(Executor executor, zzcgy zzcgy2, zzffk zzffk2, zzffm zzffm2) {
        super(executor, zzcgy2, zzffm2);
        this.zzf = zzffk2;
        zzffk2.zza(this.zzb);
    }

    public final Map<String, String> zza() {
        return new HashMap<String, String>(this.zzb);
    }
}
