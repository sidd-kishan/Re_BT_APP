/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzghf
 *  com.google.android.gms.internal.ads.zzghg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghf;
import com.google.android.gms.internal.ads.zzghg;

final class zzggz
implements zzghg {
    private final zzghg[] zza;

    zzggz(zzghg ... zzghgArray) {
        this.zza = zzghgArray;
    }

    public final boolean zzb(Class<?> clazz) {
        zzghg[] zzghgArray = this.zza;
        int n = 0;
        while (n < 2) {
            if (zzghgArray[n].zzb(clazz)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public final zzghf zzc(Class<?> object) {
        zzghg[] zzghgArray = this.zza;
        for (int i = 0; i < 2; ++i) {
            zzghg zzghg2 = zzghgArray[i];
            if (!zzghg2.zzb((Class)object)) continue;
            return zzghg2.zzc((Class)object);
        }
        object = ((String)(object = String.valueOf(((Class)object).getName()))).length() != 0 ? "No factory is available for message type: ".concat((String)object) : new String("No factory is available for message type: ");
        object = new UnsupportedOperationException((String)object);
        throw object;
    }
}
