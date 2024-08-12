/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbuw
 *  com.google.android.gms.internal.ads.zzbuy
 *  com.google.android.gms.internal.ads.zzbuz
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 *  com.google.android.gms.internal.ads.zzcod
 *  com.google.android.gms.internal.ads.zzcog
 *  com.google.android.gms.measurement.api.AppMeasurementSdk
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbuw;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;
import com.google.android.gms.internal.ads.zzcod;
import com.google.android.gms.internal.ads.zzcog;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

final class zzbux
implements Runnable {
    private final zzbuz zza;
    private final Context zzb;
    private final String zzc;

    zzbux(zzbuz zzbuz2, Context context, String string) {
        this.zza = zzbuz2;
        this.zzb = context;
        this.zzc = string;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void run() {
        void var1_5;
        Context context = this.zzb;
        String string = this.zzc;
        zzbjl.zza((Context)context);
        Bundle bundle = new Bundle();
        zzbjd zzbjd2 = zzbjl.zzac;
        bundle.putBoolean("measurementEnabled", ((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue());
        zzbjd2 = zzbjl.zzaj;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        bundle = AppMeasurementSdk.getInstance((Context)context, (String)"FA-Ads", (String)"am", (String)string, (Bundle)bundle);
        try {
            string = (zzcog)zzcgx.zza((Context)context, (String)"com.google.android.gms.ads.measurement.DynamiteMeasurementManager", (zzcgv)zzbuy.zza);
            zzbjd2 = ObjectWrapper.wrap((Object)context);
            context = new zzbuw((AppMeasurementSdk)bundle);
            string.zze((IObjectWrapper)zzbjd2, (zzcod)context);
            return;
        }
        catch (RemoteException remoteException) {
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (zzcgw zzcgw2) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_5);
    }
}
