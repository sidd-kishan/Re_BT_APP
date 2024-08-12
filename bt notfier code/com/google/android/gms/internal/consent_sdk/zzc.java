/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.zzai
 *  com.google.android.gms.internal.consent_sdk.zzaz
 *  com.google.android.gms.internal.consent_sdk.zzj
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzai;
import com.google.android.gms.internal.consent_sdk.zzaz;
import com.google.android.gms.internal.consent_sdk.zzj;

public abstract class zzc {
    private static zzc zza;

    public static zzc zza(Context object) {
        synchronized (zzc.class) {
            if (zza == null) {
                zzai zzai2 = new zzai(null);
                zza = zzai2.zza((Application)object.getApplicationContext()).zza();
            }
            object = zza;
            return object;
        }
    }

    public abstract zzj zza();

    public abstract zzaz zzb();
}
