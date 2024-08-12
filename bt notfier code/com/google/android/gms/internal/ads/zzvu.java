/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzvu {
    private final String zza;
    private final String zzb;

    public zzvu(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzvu)object;
        if (!TextUtils.equals((CharSequence)this.zza, (CharSequence)((zzvu)object).zza)) return false;
        if (!TextUtils.equals((CharSequence)this.zzb, (CharSequence)((zzvu)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31 + this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza;
        String string2 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 20 + String.valueOf(string2).length());
        stringBuilder.append("Header[name=");
        stringBuilder.append(string);
        stringBuilder.append(",value=");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
