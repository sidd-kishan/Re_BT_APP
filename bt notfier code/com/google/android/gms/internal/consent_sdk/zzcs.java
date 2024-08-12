/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzcu
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzcu;

public final class zzcs<T>
implements zzcp<T> {
    private static final zzcs<Object> zza = new zzcs<Object>(null);
    private final T zzb;

    private zzcs(T t) {
        this.zzb = t;
    }

    public static <T> zzcp<T> zza(T t) {
        return new zzcs<Object>(zzcu.zza(t, (String)"instance cannot be null"));
    }

    public final T zza() {
        return this.zzb;
    }
}
