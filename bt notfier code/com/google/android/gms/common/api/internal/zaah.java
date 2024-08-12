/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaar
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaar;

final class zaah
implements Runnable {
    final zaar zaa;

    zaah(zaar zaar2) {
        this.zaa = zaar2;
    }

    @Override
    public final void run() {
        zaar.zaj((zaar)this.zaa).cancelAvailabilityErrorNotifications(zaar.zai((zaar)this.zaa));
    }
}
