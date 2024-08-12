/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

final class zzffg {
    public final String zza;
    public final String zzb;

    public zzffg(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzffg)) {
            return false;
        }
        object = (zzffg)object;
        if (!this.zza.equals(((zzffg)object).zza)) return false;
        if (!this.zzb.equals(((zzffg)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        String string = String.valueOf(this.zza);
        String string2 = String.valueOf(this.zzb);
        string2 = string2.length() != 0 ? string.concat(string2) : new String(string);
        return string2.hashCode();
    }
}
