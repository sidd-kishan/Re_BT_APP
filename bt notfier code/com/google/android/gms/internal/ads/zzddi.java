/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.internal.ads.zzddc
 *  com.google.android.gms.internal.ads.zzddd
 *  com.google.android.gms.internal.ads.zzdde
 *  com.google.android.gms.internal.ads.zzddf
 *  com.google.android.gms.internal.ads.zzddg
 *  com.google.android.gms.internal.ads.zzddh
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.internal.ads.zzddc;
import com.google.android.gms.internal.ads.zzddd;
import com.google.android.gms.internal.ads.zzdde;
import com.google.android.gms.internal.ads.zzddf;
import com.google.android.gms.internal.ads.zzddg;
import com.google.android.gms.internal.ads.zzddh;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import java.util.Set;

public final class zzddi
extends zzdgm<zzo>
implements zzo {
    public zzddi(Set<zzdih<zzo>> set) {
        super(set);
    }

    public final void zzbp() {
        synchronized (this) {
            this.zzk(zzddh.zza);
            return;
        }
    }

    public final void zzbq() {
        synchronized (this) {
            this.zzk(zzddf.zza);
            return;
        }
    }

    public final void zzbr() {
        synchronized (this) {
            this.zzk(zzddg.zza);
            return;
        }
    }

    public final void zzbs(int n) {
        synchronized (this) {
            zzddc zzddc2 = new zzddc(n);
            this.zzk((zzdgl)zzddc2);
            return;
        }
    }

    public final void zzd() {
        synchronized (this) {
            this.zzk(zzddd.zza);
            return;
        }
    }

    public final void zze() {
        synchronized (this) {
            this.zzk(zzdde.zza);
            return;
        }
    }
}
