/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import java.util.Map;

final class zzdob
implements zzbpr {
    static final zzbpr zza = new zzdob();

    private zzdob() {
    }

    public final void zza(Object object, Map map) {
        object = (zzcml)object;
        zze.zzd((String)"Show native ad policy validator overlay.");
        object.zzH().setVisibility(0);
    }
}
