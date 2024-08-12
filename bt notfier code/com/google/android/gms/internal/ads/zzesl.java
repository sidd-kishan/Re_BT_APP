/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.internal.ads.zzeso
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzeso;
import com.google.android.gms.internal.ads.zzfln;

final class zzesl
implements zzfln {
    static final zzfln zza = new zzesl();

    private zzesl() {
    }

    public final Object apply(Object object) {
        object = (AdvertisingIdClient.Info)object;
        object.getClass();
        return new zzeso((AdvertisingIdClient.Info)object, null);
    }
}
