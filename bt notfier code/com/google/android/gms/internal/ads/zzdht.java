/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdho
 *  com.google.android.gms.internal.ads.zzdhp
 *  com.google.android.gms.internal.ads.zzdhq
 *  com.google.android.gms.internal.ads.zzdhr
 *  com.google.android.gms.internal.ads.zzdhs
 *  com.google.android.gms.internal.ads.zzdhv
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdho;
import com.google.android.gms.internal.ads.zzdhp;
import com.google.android.gms.internal.ads.zzdhq;
import com.google.android.gms.internal.ads.zzdhr;
import com.google.android.gms.internal.ads.zzdhs;
import com.google.android.gms.internal.ads.zzdhv;
import com.google.android.gms.internal.ads.zzdih;
import java.util.Set;

public final class zzdht
extends zzdgm<zzdhv>
implements zzdhv {
    public zzdht(Set<zzdih<zzdhv>> set) {
        super(set);
    }

    public final void zza(String string) {
        this.zzk((zzdgl)new zzdho(string));
    }

    public final void zzb(String string) {
        this.zzk((zzdgl)new zzdhp(string));
    }

    public final void zzc(String string, String string2) {
        this.zzk((zzdgl)new zzdhq(string, string2));
    }

    public final void zzd() {
        this.zzk(zzdhr.zza);
    }

    public final void zze() {
        this.zzk(zzdhs.zza);
    }
}
