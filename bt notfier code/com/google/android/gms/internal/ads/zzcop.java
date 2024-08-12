/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcom
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcom;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import java.lang.ref.WeakReference;

public final class zzcop
implements zzgla<WeakReference<Context>> {
    private final zzcom zza;

    public zzcop(zzcom zzcom2) {
        this.zza = zzcom2;
    }

    public final WeakReference<Context> zza() {
        WeakReference weakReference = this.zza.zzb();
        zzgli.zzb((Object)weakReference);
        return weakReference;
    }
}
