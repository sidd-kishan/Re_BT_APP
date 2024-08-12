/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 */
package com.google.android.gms.ads.identifier;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

static final class AdvertisingIdClient.zza
extends Thread {
    private WeakReference<AdvertisingIdClient> zzm;
    private long zzn;
    CountDownLatch zzo;
    boolean zzp;

    public AdvertisingIdClient.zza(AdvertisingIdClient advertisingIdClient, long l) {
        this.zzm = new WeakReference<AdvertisingIdClient>(advertisingIdClient);
        this.zzn = l;
        this.zzo = new CountDownLatch(1);
        this.zzp = false;
        this.start();
    }

    private final void disconnect() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient)this.zzm.get();
        if (advertisingIdClient == null) return;
        advertisingIdClient.finish();
        this.zzp = true;
    }

    @Override
    public final void run() {
        try {
            if (this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) return;
            this.disconnect();
            return;
        }
        catch (InterruptedException interruptedException) {
            this.disconnect();
            return;
        }
    }
}
