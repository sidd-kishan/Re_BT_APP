/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public final class zza {
    private int zza;

    public final zza zza(int n) {
        this.zza = 1;
        return this;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putInt("capabilities", this.zza);
        return bundle;
    }
}
