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

public final class zzcoo
implements zzgla<Context> {
    private final zzcom zza;

    public zzcoo(zzcom zzcom2) {
        this.zza = zzcom2;
    }

    public final Context zza() {
        Context context = this.zza.zza();
        zzgli.zzb((Object)context);
        return context;
    }
}
