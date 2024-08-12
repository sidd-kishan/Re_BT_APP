/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzazj
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzezz;
import java.util.Map;

public final class zzdko
implements zzdcq,
zzo {
    IObjectWrapper zza;
    private final Context zzb;
    private final zzcml zzc;
    private final zzezz zzd;
    private final zzcgz zze;
    private final zzazj zzf;

    public zzdko(Context context, zzcml zzcml2, zzezz zzezz2, zzcgz zzcgz2, zzazj zzazj2) {
        this.zzb = context;
        this.zzc = zzcml2;
        this.zzd = zzezz2;
        this.zze = zzcgz2;
        this.zzf = zzazj2;
    }

    public final void zzbp() {
        if (this.zza == null) return;
        zzcml zzcml2 = this.zzc;
        if (zzcml2 == null) return;
        zzcml2.zze("onSdkImpression", (Map)new ArrayMap());
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        this.zza = null;
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzf() {
        Object object;
        Object object2;
        if (this.zzf != zzazj.zzh && this.zzf != zzazj.zzd) {
            if (this.zzf != zzazj.zzk) return;
        }
        if (!this.zzd.zzP) return;
        if (this.zzc == null) return;
        if (!zzt.zzr().zza(this.zzb)) return;
        Object object3 = this.zze;
        int n = ((zzcgz)object3).zzb;
        int n2 = ((zzcgz)object3).zzc;
        object3 = new StringBuilder(23);
        ((StringBuilder)object3).append(n);
        ((StringBuilder)object3).append(".");
        ((StringBuilder)object3).append(n2);
        String string = ((StringBuilder)object3).toString();
        String string2 = this.zzd.zzR.zza();
        if (this.zzd.zzR.zzb() == 1) {
            object3 = zzbzl.zzc;
            object2 = zzbzm.zzb;
            object = object3;
        } else {
            object3 = this.zzd.zzU == 2 ? zzbzm.zzd : zzbzm.zza;
            object = zzbzl.zza;
            object2 = object3;
        }
        object3 = zzt.zzr().zzd(string, this.zzc.zzG(), "", "javascript", string2, object2, (zzbzl)object, this.zzd.zzai);
        this.zza = object3;
        if (object3 == null) return;
        zzt.zzr().zzh(this.zza, (View)this.zzc);
        this.zzc.zzak(this.zza);
        zzt.zzr().zzf(this.zza);
        this.zzc.zze("onSdkLoaded", (Map)new ArrayMap());
    }
}
