/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzdnn
 *  com.google.android.gms.internal.ads.zzdrh
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzdnn;
import com.google.android.gms.internal.ads.zzdrh;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdno
implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference<View> zzc;
    private final zzdrh zzd;
    private final Clock zze;
    private zzbob zzf;
    private zzbpr<Object> zzg;

    public zzdno(zzdrh zzdrh2, Clock clock) {
        this.zzd = zzdrh2;
        this.zze = clock;
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        View view = this.zzc;
        if (view == null) {
            return;
        }
        if ((view = (View)view.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    public final void onClick(View object) {
        WeakReference<View> weakReference = this.zzc;
        if (weakReference == null) return;
        if (weakReference.get() != object) return;
        if (this.zza != null && this.zzb != null) {
            object = new HashMap();
            object.put("id", this.zza);
            object.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb));
            object.put("messageType", "onePointFiveClick");
            this.zzd.zzg("sendMessageToNativeJs", (Map)object);
        }
        this.zzd();
    }

    public final void zza(zzbob zzbob2) {
        this.zzf = zzbob2;
        zzbpr<Object> zzbpr2 = this.zzg;
        if (zzbpr2 != null) {
            this.zzd.zzf("/unconfirmedClick", zzbpr2);
        }
        this.zzg = zzbob2 = new zzdnn(this, zzbob2);
        this.zzd.zze("/unconfirmedClick", (zzbpr)zzbob2);
    }

    public final zzbob zzb() {
        return this.zzf;
    }

    public final void zzc() {
        if (this.zzf == null) {
            return;
        }
        if (this.zzb == null) {
            return;
        }
        this.zzd();
        try {
            this.zzf.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
