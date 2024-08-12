/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzfln;

final class zzeqw
implements zzfln {
    private final String zza;

    zzeqw(String string) {
        this.zza = string;
    }

    public final Object apply(Object object) {
        String string = this.zza;
        object = (Throwable)object;
        object = String.valueOf(string);
        object = ((String)object).length() != 0 ? "Error calling adapter: ".concat((String)object) : new String("Error calling adapter: ");
        zze.zzf((String)object);
        return null;
    }
}
