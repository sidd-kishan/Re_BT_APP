/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzaya
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcui
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfav
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcui;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfav;
import java.util.List;

public final class zzcuq
extends zzcxg {
    private final View zzc;
    private final zzcml zzd;
    private final zzfaa zze;
    private final int zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final zzcui zzi;
    private zzaya zzj;

    zzcuq(zzcxf zzcxf2, View view, zzcml zzcml2, zzfaa zzfaa2, int n, boolean bl, boolean bl2, zzcui zzcui2) {
        super(zzcxf2);
        this.zzc = view;
        this.zzd = zzcml2;
        this.zze = zzfaa2;
        this.zzf = n;
        this.zzg = bl;
        this.zzh = bl2;
        this.zzi = zzcui2;
    }

    public final zzfaa zza() {
        return zzfav.zza((List)this.zzb.zzr, (zzfaa)this.zze);
    }

    public final View zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        if (this.zzd.zzR() == null) return false;
        if (!this.zzd.zzR().zzd()) return false;
        return true;
    }

    public final boolean zzg() {
        if (!this.zzd.zzT()) return false;
        return true;
    }

    public final void zzh(zzaxq zzaxq2) {
        this.zzd.zzax(zzaxq2);
    }

    public final void zzi(long l, int n) {
        this.zzi.zza(l, n);
    }

    public final void zzj(zzaya zzaya2) {
        this.zzj = zzaya2;
    }

    public final zzaya zzk() {
        return this.zzj;
    }
}
