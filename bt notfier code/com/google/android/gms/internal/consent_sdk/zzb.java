/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.internal.consent_sdk.zza
 *  com.google.android.gms.internal.consent_sdk.zzca
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.consent_sdk.zza;
import com.google.android.gms.internal.consent_sdk.zzca;
import java.io.IOException;

final class zzb {
    private final Application zza;

    public zzb(Application application) {
        this.zza = application;
    }

    /*
     * WARNING - void declaration
     */
    public final zza zza() {
        void var1_5;
        try {
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)this.zza);
            info = new zza(info.getId(), info.isLimitAdTrackingEnabled());
            return info;
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        zzca.zza((String)"Failed to get ad id.", (Throwable)var1_5);
        return null;
    }
}
