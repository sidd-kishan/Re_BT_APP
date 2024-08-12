/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcgl
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcgl;

final class zzn
implements zzcgl {
    final Context zza;
    final String zzb;

    zzn(zzs zzs2, Context context, String string) {
        this.zza = context;
        this.zzb = string;
    }

    public final void zza(String string) {
        zzt.zzc();
        zzs.zzN((Context)this.zza, (String)this.zzb, (String)string);
    }
}
