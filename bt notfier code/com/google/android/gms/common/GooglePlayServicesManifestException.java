/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 */
package com.google.android.gms.common;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

public class GooglePlayServicesManifestException
extends IllegalStateException {
    private final int zza;

    public GooglePlayServicesManifestException(int n, String string) {
        super(string);
        this.zza = n;
    }

    public int getActualVersion() {
        return this.zza;
    }

    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
