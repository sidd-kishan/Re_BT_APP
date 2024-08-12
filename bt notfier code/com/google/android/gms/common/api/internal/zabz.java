/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;

final class zabz
implements Runnable {
    private final NonGmsServiceBrokerClient zaa;
    private final IBinder zab;

    zabz(NonGmsServiceBrokerClient nonGmsServiceBrokerClient, IBinder iBinder) {
        this.zaa = nonGmsServiceBrokerClient;
        this.zab = iBinder;
    }

    @Override
    public final void run() {
        this.zaa.zac(this.zab);
    }
}
