/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;

public final class zzao
implements zzcp<zzal> {
    private final zzct<Application> zza;

    public zzao(zzct<Application> zzct2) {
        this.zza = zzct2;
    }

    public final /* synthetic */ Object zza() {
        return new zzal((Application)this.zza.zza());
    }
}
