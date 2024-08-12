/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzfx {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzfx(String string, boolean bl, boolean bl2) {
        this.zza = string;
        this.zzb = bl;
        this.zzc = bl2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (object.getClass() != zzfx.class) {
            return false;
        }
        object = (zzfx)object;
        if (!TextUtils.equals((CharSequence)this.zza, (CharSequence)((zzfx)object).zza)) return false;
        if (this.zzb != ((zzfx)object).zzb) return false;
        if (this.zzc != ((zzfx)object).zzc) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zza.hashCode();
        boolean bl = this.zzb;
        int n2 = 1237;
        int n3 = true != bl ? 1237 : 1231;
        if (!this.zzc) return ((n + 31) * 31 + n3) * 31 + n2;
        n2 = 1231;
        return ((n + 31) * 31 + n3) * 31 + n2;
    }
}
