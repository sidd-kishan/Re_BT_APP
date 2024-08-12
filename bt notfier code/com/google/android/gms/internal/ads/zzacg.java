/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class zzacg
extends zzacz {
    public zzacg(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "NSYe0Ak7CUXd9zFZA3bczJ8pTgBK/kfUu9ICpHR+lQrTNc8+V7Owo49e2WIp0407", "Ux7t0A/7z2bV/IDvLZJgV4tTxr0Vvc1KngWKlG2Szwg=", zzyj2, n, 24);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzc() {
        String string;
        AdvertisingIdClient.Info info;
        AdvertisingIdClient advertisingIdClient = this.zzb.zzt();
        if (advertisingIdClient == null) {
            return;
        }
        try {
            info = advertisingIdClient.getInfo();
            string = zzabu.zza((String)info.getId());
            if (string == null) return;
            advertisingIdClient = this.zze;
            synchronized (advertisingIdClient) {
            }
        }
        catch (IOException iOException) {
            return;
        }
        {
            this.zze.zzS(string);
            this.zze.zzT(info.isLimitAdTrackingEnabled());
            this.zze.zzaa(6);
            return;
        }
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzb.zzi()) {
            this.zzc();
            return;
        }
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzS((String)this.zzf.invoke(null, this.zzb.zzc()));
            return;
        }
    }

    public final Void zzk() throws Exception {
        if (this.zzb.zzd()) {
            super.zzk();
            return null;
        }
        if (!this.zzb.zzi()) return null;
        this.zzc();
        return null;
    }
}
