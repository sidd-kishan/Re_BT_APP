/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;

final class zaca
implements Runnable {
    private final NonGmsServiceBrokerClient zaa;

    zaca(NonGmsServiceBrokerClient nonGmsServiceBrokerClient) {
        this.zaa = nonGmsServiceBrokerClient;
    }

    @Override
    public final void run() {
        this.zaa.zab();
    }
}
