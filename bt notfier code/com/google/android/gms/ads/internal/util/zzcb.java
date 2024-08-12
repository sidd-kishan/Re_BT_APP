/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcgy
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcgy;

public final class zzcb
extends zzb {
    private final zzcgy zza;
    private final String zzb;

    public zzcb(Context object, String string, String string2) {
        object = zzt.zzc().zzi(object, string);
        this.zza = new zzcgy((String)object);
        this.zzb = string2;
    }

    public final void zza() {
        this.zza.zza(this.zzb);
    }
}
