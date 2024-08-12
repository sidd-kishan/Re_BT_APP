/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.AdapterStatus
 *  com.google.android.gms.ads.initialization.InitializationStatus
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

public final class zzbru
implements InitializationStatus {
    private final Map<String, AdapterStatus> zza;

    public zzbru(Map<String, AdapterStatus> map) {
        this.zza = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zza;
    }
}
