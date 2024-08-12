/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.ads.mediation.NetworkExtras
 */
package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras
implements NetworkExtras {
    private final Bundle zza;

    public AdMobExtras(Bundle object) {
        object = object != null ? new Bundle(object) : null;
        this.zza = object;
    }

    public Bundle getExtras() {
        return this.zza;
    }
}
