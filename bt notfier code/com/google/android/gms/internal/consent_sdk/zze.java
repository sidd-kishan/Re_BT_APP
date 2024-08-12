/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzg
 *  com.google.android.gms.internal.consent_sdk.zzi
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzg;
import com.google.android.gms.internal.consent_sdk.zzi;
import java.util.concurrent.Executor;

public final class zze {
    private final Executor zza;

    zze(Executor executor) {
        this.zza = executor;
    }

    public final Executor zza() {
        return this.zza;
    }

    public final void zza(String string, String string2, zzi ... zziArray) {
        this.zza.execute((Runnable)new zzg(string, string2, zziArray));
    }
}
