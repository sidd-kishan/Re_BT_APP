/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.internal.ads.zzcfw
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzchl;
import java.io.IOException;

final class zzcfv
implements Runnable {
    final Context zza;
    final zzchl zzb;

    zzcfv(zzcfw zzcfw2, Context context, zzchl zzchl2) {
        this.zza = context;
        this.zzb = zzchl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void run() {
        void var1_6;
        try {
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.zza);
            this.zzb.zzc((Object)info);
            return;
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
        }
        catch (IllegalStateException illegalStateException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.zzb.zzd((Throwable)var1_6);
        zzcgt.zzg((String)"Exception while getting advertising Id info", (Throwable)var1_6);
    }
}
