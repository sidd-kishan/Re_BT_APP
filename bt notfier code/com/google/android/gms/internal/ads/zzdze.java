/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdze
implements zzgla<String> {
    private final zzgln<Context> zza;

    public zzdze(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final String zza() {
        String string = ((zzfbv)this.zza).zza().getPackageName();
        zzgli.zzb((Object)string);
        return string;
    }
}
