/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzezz;
import java.util.Map;

public final class zzcww
implements zzdcq,
zzdbw {
    private final Context zza;
    private final zzcml zzb;
    private final zzezz zzc;
    private final zzcgz zzd;
    private IObjectWrapper zze;
    private boolean zzf;

    public zzcww(Context context, zzcml zzcml2, zzezz zzezz2, zzcgz zzcgz2) {
        this.zza = context;
        this.zzb = zzcml2;
        this.zzc = zzezz2;
        this.zzd = zzcgz2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zza() {
        synchronized (this) {
            zzbzl zzbzl2;
            boolean bl = this.zzc.zzP;
            if (!bl) {
                return;
            }
            Object object = this.zzb;
            if (object == null) {
                return;
            }
            bl = zzt.zzr().zza(this.zza);
            if (!bl) {
                return;
            }
            object = this.zzd;
            int n = ((zzcgz)object).zzb;
            int n2 = ((zzcgz)object).zzc;
            object = new StringBuilder(23);
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(".");
            ((StringBuilder)object).append(n2);
            String string = ((StringBuilder)object).toString();
            String string2 = this.zzc.zzR.zza();
            if (this.zzc.zzR.zzb() == 1) {
                zzbzl2 = zzbzl.zzc;
                object = zzbzm.zzb;
            } else {
                zzbzl2 = zzbzl.zza;
                object = this.zzc.zzf == 1 ? zzbzm.zzc : zzbzm.zza;
            }
            zzbzl2 = zzt.zzr().zzd(string, this.zzb.zzG(), "", "javascript", string2, (zzbzm)object, zzbzl2, this.zzc.zzai);
            this.zze = zzbzl2;
            object = this.zzb;
            if (zzbzl2 == null) return;
            zzt.zzr().zzh(this.zze, (View)object);
            this.zzb.zzak(this.zze);
            zzt.zzr().zzf(this.zze);
            this.zzf = true;
            zzbzl2 = this.zzb;
            object = new ArrayMap();
            zzbzl2.zze("onSdkLoaded", (Map)object);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzf() {
        synchronized (this) {
            boolean bl = this.zzf;
            if (bl) {
                return;
            }
            this.zza();
            return;
        }
    }

    public final void zzg() {
        synchronized (this) {
            if (!this.zzf) {
                this.zza();
            }
            if (!this.zzc.zzP) return;
            if (this.zze == null) return;
            zzcml zzcml2 = this.zzb;
            if (zzcml2 == null) return;
            ArrayMap arrayMap = new ArrayMap();
            zzcml2.zze("onSdkImpression", (Map)arrayMap);
            return;
        }
    }
}
