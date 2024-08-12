/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzdpp
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzdpp;
import com.google.android.gms.internal.ads.zzfln;

final class zzdpo
implements zzfln {
    private final String zza;

    zzdpo(String string) {
        this.zza = string;
    }

    public final Object apply(Object object) {
        return new zzdpp(this.zza, (zzblr)object);
    }
}
