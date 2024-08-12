/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzdbx
 *  com.google.android.gms.internal.ads.zzdby
 *  com.google.android.gms.internal.ads.zzdbz
 *  com.google.android.gms.internal.ads.zzdca
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzdby;
import com.google.android.gms.internal.ads.zzdbz;
import com.google.android.gms.internal.ads.zzdca;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import java.util.Set;

public final class zzdcb
extends zzdgm<zzdbx> {
    public zzdcb(Set<zzdih<zzdbx>> set) {
        super(set);
    }

    public final void zza(Context context) {
        this.zzk((zzdgl)new zzdby(context));
    }

    public final void zzb(Context context) {
        this.zzk((zzdgl)new zzdbz(context));
    }

    public final void zzc(Context context) {
        this.zzk((zzdgl)new zzdca(context));
    }
}
