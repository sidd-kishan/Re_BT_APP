/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfik
 *  com.google.android.gms.internal.ads.zzfin
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfin;

final class zzfio
extends zzfik {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzfio(String string, boolean bl, boolean bl2, zzfin zzfin2) {
        this.zza = string;
        this.zzb = bl;
        this.zzc = bl2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzfik)) return false;
        if (!this.zza.equals((object = (zzfik)object).zza())) return false;
        if (this.zzb != object.zzb()) return false;
        if (this.zzc != object.zzc()) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zza.hashCode();
        boolean bl = this.zzb;
        int n2 = 1237;
        int n3 = true != bl ? 1237 : 1231;
        if (!this.zzc) return ((n ^ 0xF4243) * 1000003 ^ n3) * 1000003 ^ n2;
        n2 = 1231;
        return ((n ^ 0xF4243) * 1000003 ^ n3) * 1000003 ^ n2;
    }

    public final String toString() {
        String string = this.zza;
        boolean bl = this.zzb;
        boolean bl2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 99);
        stringBuilder.append("AdShield2Options{clientVersion=");
        stringBuilder.append(string);
        stringBuilder.append(", shouldGetAdvertisingId=");
        stringBuilder.append(bl);
        stringBuilder.append(", isGooglePlayServicesAvailable=");
        stringBuilder.append(bl2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzc;
    }
}
