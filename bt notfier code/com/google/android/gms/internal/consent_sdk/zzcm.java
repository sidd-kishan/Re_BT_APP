/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzci
 *  com.google.android.gms.internal.consent_sdk.zzcl
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzci;
import com.google.android.gms.internal.consent_sdk.zzcl;

final class zzcm
extends zzci {
    private final zzcl zza = new zzcl();

    zzcm() {
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 == throwable) throw new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        if (throwable2 == null) throw new NullPointerException("The suppressed exception cannot be null.");
        this.zza.zza(throwable, true).add(throwable2);
    }
}
