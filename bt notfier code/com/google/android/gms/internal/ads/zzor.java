/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzou;

public final class zzor {
    public final zzou zza;
    public final zzou zzb;

    public zzor(zzou zzou2, zzou zzou3) {
        this.zza = zzou2;
        this.zzb = zzou3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzor)object;
        if (!this.zza.equals((Object)((zzor)object).zza)) return false;
        if (!this.zzb.equals((Object)((zzor)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31 + this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza.toString();
        String string2 = this.zza.equals((Object)this.zzb) ? "" : ", ".concat(this.zzb.toString());
        StringBuilder stringBuilder = new StringBuilder(string.length() + 2 + string2.length());
        stringBuilder.append("[");
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
