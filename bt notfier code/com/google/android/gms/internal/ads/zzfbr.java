/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzcfy
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzdbf
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzcfy;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzdbf;
import java.util.HashSet;

public final class zzfbr
implements zzdbf {
    private final HashSet<zzcfy> zza = new HashSet();
    private final Context zzb;
    private final zzcgi zzc;

    public zzfbr(Context context, zzcgi zzcgi2) {
        this.zzb = context;
        this.zzc = zzcgi2;
    }

    public final void zzb(HashSet<zzcfy> hashSet) {
        synchronized (this) {
            this.zza.clear();
            this.zza.addAll(hashSet);
            return;
        }
    }

    public final void zzbD(zzbcz zzbcz2) {
        synchronized (this) {
            if (zzbcz2.zza == 3) return;
            this.zzc.zzc(this.zza);
            return;
        }
    }

    public final Bundle zzc() {
        return this.zzc.zzk(this.zzb, this);
    }
}
