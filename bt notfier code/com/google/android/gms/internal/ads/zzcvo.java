/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcvm
 *  com.google.android.gms.internal.ads.zzcww
 *  com.google.android.gms.internal.ads.zzcwy
 *  com.google.android.gms.internal.ads.zzcxe
 *  com.google.android.gms.internal.ads.zzdco
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcvm;
import com.google.android.gms.internal.ads.zzcww;
import com.google.android.gms.internal.ads.zzcwy;
import com.google.android.gms.internal.ads.zzcxe;
import com.google.android.gms.internal.ads.zzdco;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfar;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzcvo {
    private final zzcxe zza;
    private final View zzb;
    private final zzfaa zzc;
    private final zzcml zzd;

    public zzcvo(View view, zzcml zzcml2, zzcxe zzcxe2, zzfaa zzfaa2) {
        this.zzb = view;
        this.zzd = zzcml2;
        this.zza = zzcxe2;
        this.zzc = zzfaa2;
    }

    public static final zzdih<zzdcq> zzf(Context context, zzcgz zzcgz2, zzezz zzezz2, zzfar zzfar2) {
        return new zzdih((Object)new zzcvm(context, zzcgz2, zzezz2, zzfar2), (Executor)zzchg.zzf);
    }

    public static final Set<zzdih<zzdcq>> zzg(zzcwy zzcwy2) {
        return Collections.singleton(new zzdih((Object)zzcwy2, (Executor)zzchg.zzf));
    }

    public static final zzdih<zzdcq> zzh(zzcww zzcww2) {
        return new zzdih((Object)zzcww2, (Executor)zzchg.zze);
    }

    public final zzcml zza() {
        return this.zzd;
    }

    public final View zzb() {
        return this.zzb;
    }

    public final zzcxe zzc() {
        return this.zza;
    }

    public final zzfaa zzd() {
        return this.zzc;
    }

    public zzdco zze(Set<zzdih<zzdcq>> set) {
        return new zzdco(set);
    }
}
