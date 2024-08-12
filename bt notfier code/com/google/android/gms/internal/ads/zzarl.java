/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzarl {
    public final String zza;
    public final boolean zzb;

    public zzarl(String string, boolean bl) {
        this.zza = string;
        this.zzb = bl;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (object.getClass() != zzarl.class) {
            return false;
        }
        object = (zzarl)object;
        if (!TextUtils.equals((CharSequence)this.zza, (CharSequence)((zzarl)object).zza)) return false;
        if (this.zzb != ((zzarl)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        String string = this.zza;
        int n = string == null ? 0 : string.hashCode();
        int n2 = true != this.zzb ? 1237 : 1231;
        return (n + 31) * 31 + n2;
    }
}
