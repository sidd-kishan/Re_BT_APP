/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzdno
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzdno;
import java.util.Map;

final class zzdnn
implements zzbpr {
    private final zzdno zza;
    private final zzbob zzb;

    zzdnn(zzdno zzdno2, zzbob zzbob2) {
        this.zza = zzdno2;
        this.zzb = zzbob2;
    }

    public final void zza(Object object, Map object2) {
        zzdno zzdno2 = this.zza;
        object = this.zzb;
        try {
            zzdno2.zzb = Long.parseLong((String)object2.get("timestamp"));
        }
        catch (NumberFormatException numberFormatException) {
            zze.zzf((String)"Failed to call parse unconfirmedClickTimestamp.");
        }
        zzdno2.zza = (String)object2.get("id");
        object2 = (String)object2.get("asset_id");
        if (object == null) {
            zze.zzd((String)"Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            object.zze((String)object2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
