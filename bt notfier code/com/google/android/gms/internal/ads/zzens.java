/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzent
 *  com.google.android.gms.internal.ads.zzerx
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzent;
import com.google.android.gms.internal.ads.zzerx;

final class zzens
implements zzerx {
    private final zzent zza;
    private final Bundle zzb;

    zzens(zzent zzent2, Bundle bundle) {
        this.zza = zzent2;
        this.zzb = bundle;
    }

    public final void zzf(Object object) {
        this.zza.zzb(this.zzb, (Bundle)object);
    }
}
