/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzfal;

final class zzeai
implements zzddx {
    private final Context zza;
    private final zzcfa zzb;

    zzeai(Context context, zzcfa zzcfa2) {
        this.zza = context;
        this.zzb = zzcfa2;
    }

    public final void zzbG(zzcbj zzcbj2) {
    }

    public final void zzq(zzfal zzfal2) {
        if (TextUtils.isEmpty((CharSequence)zzfal2.zzb.zzb.zzd)) return;
        this.zzb.zzd(this.zza, zzfal2.zza.zza.zzd);
        this.zzb.zzp(this.zza, zzfal2.zzb.zzb.zzd);
    }
}
