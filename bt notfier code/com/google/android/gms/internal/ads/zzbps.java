/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzdyc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzdyc;
import java.util.Map;

public final class zzbps
implements zzbpr<Object> {
    private final zzdyc zza;

    public zzbps(zzdyc zzdyc2) {
        Preconditions.checkNotNull((Object)zzdyc2, (Object)"The Inspector Manager must not be null");
        this.zza = zzdyc2;
    }

    public final void zza(Object object, Map<String, String> map) {
        long l;
        if (map == null) return;
        if (!map.containsKey("extras")) return;
        boolean bl = map.containsKey("expires");
        long l2 = l = Long.MAX_VALUE;
        if (bl) {
            try {
                l2 = Long.parseLong(map.get("expires"));
            }
            catch (NumberFormatException numberFormatException) {
                l2 = l;
            }
        }
        this.zza.zzi(map.get("extras"), l2);
    }
}
