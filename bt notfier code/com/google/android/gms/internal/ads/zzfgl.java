/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfhk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfhk;

public final class zzfgl {
    private final String zza;
    private final String zzb;

    private zzfgl(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public static zzfgl zza(String string, String string2) {
        zzfhk.zzb((String)string, (String)"Name is null or empty");
        zzfhk.zzb((String)string2, (String)"Version is null or empty");
        return new zzfgl(string, string2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
