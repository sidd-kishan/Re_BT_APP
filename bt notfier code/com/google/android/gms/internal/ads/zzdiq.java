/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdip
 *  com.google.android.gms.internal.ads.zzdis
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdip;
import com.google.android.gms.internal.ads.zzdis;
import java.util.Set;

public final class zzdiq
extends zzdgm<zzdis> {
    public zzdiq(Set<zzdih<zzdis>> set) {
        super(set);
    }

    public final void zza() {
        synchronized (this) {
            this.zzk(zzdip.zza);
            return;
        }
    }
}
