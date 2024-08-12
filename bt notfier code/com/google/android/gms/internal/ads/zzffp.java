/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffk
 *  com.google.android.gms.internal.ads.zzffm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzffm;
import java.util.Map;

public final class zzffp
implements zzffc {
    private final zzffm zza;
    private final zzffk zzb;

    public zzffp(zzffm zzffm2, zzffk zzffk2) {
        this.zza = zzffm2;
        this.zzb = zzffk2;
    }

    public final void zza(zzffb zzffb2) {
    }

    public final String zzb(zzffb object) {
        zzffm zzffm2 = this.zza;
        object = object.zzj();
        this.zzb.zza((Map)object);
        return zzffm2.zza((Map)object);
    }
}
