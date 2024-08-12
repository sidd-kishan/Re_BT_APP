/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.internal.util.zzb
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.internal.ads.zzcgs
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcgs;
import java.io.IOException;

final class zzc
extends zzb {
    private final Context zza;

    zzc(Context context) {
        this.zza = context;
    }

    public final void zza() {
        StringBuilder stringBuilder;
        boolean bl;
        block5: {
            try {
                bl = AdvertisingIdClient.getIsAdIdFakeForDebugLogging((Context)this.zza);
                break block5;
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
            zze.zzg((String)"Fail to get isAdIdFakeForDebugLogging", (Throwable)((Object)stringBuilder));
            bl = false;
        }
        zzcgs.zzh((boolean)bl);
        stringBuilder = new StringBuilder(43);
        stringBuilder.append("Update ad debug logging enablement as ");
        stringBuilder.append(bl);
        zze.zzi((String)stringBuilder.toString());
    }
}
