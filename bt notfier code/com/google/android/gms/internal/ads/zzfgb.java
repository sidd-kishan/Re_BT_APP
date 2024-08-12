/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzfgt
 *  com.google.android.gms.internal.ads.zzfgv
 *  com.google.android.gms.internal.ads.zzfgy
 *  com.google.android.gms.internal.ads.zzfhi
 *  com.google.android.gms.internal.ads.zzfhk
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzfgt;
import com.google.android.gms.internal.ads.zzfgv;
import com.google.android.gms.internal.ads.zzfgy;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhk;

public final class zzfgb {
    private boolean zza;

    final boolean zza() {
        return this.zza;
    }

    final void zzb(Context context) {
        zzfhk.zza((Object)context, (String)"Application Context cannot be null");
        if (this.zza) return;
        this.zza = true;
        zzfgy.zza().zzb(context);
        zzfgt.zza().zzb(context);
        zzfhi.zza((Context)context);
        zzfgv.zza().zzc(context);
    }
}
