/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.measurement.zzv
 *  com.google.android.gms.measurement.internal.zzgq
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzgq;

final class zzbj
extends zzv {
    private final zzgq zza;

    zzbj(zzgq zzgq2) {
        this.zza = zzgq2;
    }

    public final void zzd(String string, String string2, Bundle bundle, long l) {
        this.zza.onEvent(string, string2, bundle, l);
    }

    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
