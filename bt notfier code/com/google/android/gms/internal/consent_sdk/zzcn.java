/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzcu
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzcu;

public final class zzcn<T>
implements zzcp<T> {
    private zzct<T> zza;

    public static <T> void zza(zzct<T> object, zzct<T> zzct2) {
        zzcu.zza(zzct2);
        object = (zzcn)object;
        if (object.zza != null) throw new IllegalStateException();
        object.zza = zzct2;
    }

    public final T zza() {
        zzct<T> zzct2 = this.zza;
        if (zzct2 == null) throw new IllegalStateException();
        return (T)zzct2.zza();
    }
}
