/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzfdy
 *  com.google.android.gms.internal.ads.zzfel
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfen
 *  com.google.android.gms.internal.ads.zzfeo
 *  com.google.android.gms.internal.ads.zzfep
 *  com.google.android.gms.internal.ads.zzfeq
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzfdy;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfen;
import com.google.android.gms.internal.ads.zzfeo;
import com.google.android.gms.internal.ads.zzfep;
import com.google.android.gms.internal.ads.zzfeq;
import com.google.android.gms.internal.ads.zzfet;
import java.util.Set;

final class zzfer
extends zzdgm<zzfet>
implements zzfel<zzfem> {
    zzfer(Set<zzdih<zzfet>> set) {
        super(set);
    }

    public final void zza(zzfdy<zzfem, ?> zzfdy2) {
        this.zzk((zzdgl)new zzfen(zzfdy2));
    }

    public final void zzb(zzfdy<zzfem, ?> zzfdy2) {
        this.zzk((zzdgl)new zzfeo(zzfdy2));
    }

    public final void zzc(zzfdy<zzfem, ?> zzfdy2, Throwable throwable) {
        this.zzk((zzdgl)new zzfep(zzfdy2, throwable));
    }

    public final void zzd(zzfdy<zzfem, ?> zzfdy2) {
        this.zzk((zzdgl)new zzfeq(zzfdy2));
    }
}
