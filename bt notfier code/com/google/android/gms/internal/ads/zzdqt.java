/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzdqp
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzgku
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzdqp;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzgku;
import java.util.Map;

public final class zzdqt
implements zzbpr<Object> {
    private final zzbnl zza;
    private final zzdrh zzb;
    private final zzgku<zzdqp> zzc;

    public zzdqt(zzdmx zzdmx2, zzdmm zzdmm2, zzdrh zzdrh2, zzgku<zzdqp> zzgku2) {
        this.zza = zzdmx2.zzg(zzdmm2.zzQ());
        this.zzb = zzdrh2;
        this.zzc = zzgku2;
    }

    public final void zza(Object object, Map<String, String> object2) {
        object = object2.get("asset");
        try {
            this.zza.zze((zzbnb)this.zzc.zzb(), (String)object);
            return;
        }
        catch (RemoteException remoteException) {
            object2 = new StringBuilder(String.valueOf(object).length() + 40);
            ((StringBuilder)object2).append("Failed to call onCustomClick for asset ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(".");
            zze.zzj((String)((StringBuilder)object2).toString(), (Throwable)remoteException);
            return;
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zze("/nativeAdCustomClick", (zzbpr)this);
    }
}
