/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.internal.consent_sdk.zzbq
 */
package com.google.android.gms.internal.consent_sdk;

import android.util.JsonWriter;
import com.google.android.gms.internal.consent_sdk.zzbq;
import java.io.IOException;

public final class zzbs
extends Enum<zzbs> {
    public static final /* enum */ zzbs zza;
    public static final /* enum */ zzbs zzb;
    public static final /* enum */ zzbs zzc;
    public static final /* enum */ zzbs zzd;
    private static final zzbs[] zze;

    static {
        zzbs zzbs2;
        zza = new zzbs();
        zzb = new zzbs();
        zzc = new zzbs();
        zzd = zzbs2 = new zzbs();
        zze = new zzbs[]{zza, zzb, zzc, zzbs2};
    }

    public static zzbs[] values() {
        return (zzbs[])zze.clone();
    }

    public final void zza(JsonWriter jsonWriter) throws IOException {
        int n = zzbq.zzb[this.ordinal()];
        if (n == 1) {
            jsonWriter.value("DEBUG_PARAM_UNKNOWN");
            return;
        }
        if (n == 2) {
            jsonWriter.value("ALWAYS_SHOW");
            return;
        }
        if (n == 3) {
            jsonWriter.value("GEO_OVERRIDE_EEA");
            return;
        }
        if (n != 4) return;
        jsonWriter.value("GEO_OVERRIDE_NON_EEA");
    }
}
