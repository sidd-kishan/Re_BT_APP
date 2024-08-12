/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzale
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzale;

public final class zzahk {
    private final zzale zza;

    public zzahk(zzale zzale2) {
        this.zza = zzale2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzahk)) {
            return false;
        }
        object = (zzahk)object;
        return this.zza.equals((Object)((zzahk)object).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }
}
