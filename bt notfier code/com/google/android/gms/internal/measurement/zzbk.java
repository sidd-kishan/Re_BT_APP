/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbr
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;

final class zzbk
extends zzbh {
    final Bundle zza;
    final Activity zzb;
    final zzbr zzc;

    zzbk(zzbr zzbr2, Bundle bundle, Activity activity) {
        this.zzc = zzbr2;
        this.zza = bundle;
        this.zzb = activity;
        super(zzbr2.zza, true);
    }

    final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zza != null) {
            Bundle bundle2;
            bundle = bundle2 = new Bundle();
            if (this.zza.containsKey("com.google.app_measurement.screen_service")) {
                Object object = this.zza.get("com.google.app_measurement.screen_service");
                bundle = bundle2;
                if (object instanceof Bundle) {
                    bundle2.putBundle("com.google.app_measurement.screen_service", (Bundle)object);
                    bundle = bundle2;
                }
            }
        } else {
            bundle = null;
        }
        ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zzc.zza))).onActivityCreated(ObjectWrapper.wrap((Object)this.zzb), bundle, this.zzi);
    }
}
