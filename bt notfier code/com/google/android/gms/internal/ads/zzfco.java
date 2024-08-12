/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfcm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfcm;

public final class zzfco
implements zzfcm {
    private final String zza;

    public zzfco(String string) {
        this.zza = string;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzfco)) {
            return false;
        }
        object = (zzfco)object;
        return this.zza.equals(((zzfco)object).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
