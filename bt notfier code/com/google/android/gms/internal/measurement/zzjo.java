/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjr;
import java.util.Map;

final class zzjo
implements Map.Entry,
Comparable<zzjo> {
    final zzjr zza;
    private final Comparable zzb;
    private Object zzc;

    zzjo(zzjr zzjr2, Comparable comparable, Object object) {
        this.zza = zzjr2;
        this.zzb = comparable;
        this.zzc = object;
    }

    private static final boolean zzb(Object object, Object object2) {
        boolean bl;
        if (object == null) {
            if (object2 == null) return true;
            bl = false;
        } else {
            bl = object.equals(object2);
        }
        return bl;
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        if (!zzjo.zzb(this.zzb, (object = (Map.Entry)object).getKey())) return false;
        if (!zzjo.zzb(this.zzc, object.getValue())) return false;
        return true;
    }

    public final Object getValue() {
        return this.zzc;
    }

    @Override
    public final int hashCode() {
        Object object = this.zzb;
        int n = 0;
        int n2 = object == null ? 0 : object.hashCode();
        object = this.zzc;
        if (object == null) return n2 ^ n;
        n = object.hashCode();
        return n2 ^ n;
    }

    public final Object setValue(Object object) {
        zzjr.zzg((zzjr)this.zza);
        Object object2 = this.zzc;
        this.zzc = object;
        return object2;
    }

    public final String toString() {
        String string = String.valueOf(this.zzb);
        String string2 = String.valueOf(this.zzc);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
