/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbjo
 *  com.google.android.gms.internal.ads.zzbjq
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbjo;
import com.google.android.gms.internal.ads.zzbjq;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzbjr {
    public static final void zza(zzbjq zzbjq2, zzbjo zzbjo2) {
        if (zzbjo2.zzb() == null) throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        if (TextUtils.isEmpty((CharSequence)zzbjo2.zzc())) throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        zzbjq2.zza(zzbjo2.zzb(), zzbjo2.zzc(), zzbjo2.zza(), zzbjo2.zzd());
    }
}
