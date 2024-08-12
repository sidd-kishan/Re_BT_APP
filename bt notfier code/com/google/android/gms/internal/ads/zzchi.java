/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfrz;

final class zzchi
implements zzfrz<Object> {
    final String zza;

    zzchi(String string) {
        this.zza = "ActiveViewListener.callActiveViewJs";
    }

    public final void zza(Throwable throwable) {
        zzt.zzg().zzl(throwable, this.zza);
    }

    public final void zzb(Object object) {
    }
}
