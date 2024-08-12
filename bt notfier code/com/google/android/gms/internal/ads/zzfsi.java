/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsk
 *  com.google.android.gms.internal.ads.zzfsl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsk;
import com.google.android.gms.internal.ads.zzfsl;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

final class zzfsi
extends AbstractOwnableSynchronizer
implements Runnable {
    private final zzfsl<?> zza;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfsi(zzfsl zzfsl2, zzfsk zzfsk2) {
        this.zza = zzfsl2;
    }

    static /* synthetic */ void zza(zzfsi zzfsi2, Thread thread) {
        super.setExclusiveOwnerThread(thread);
    }

    @Override
    public final void run() {
    }

    public final String toString() {
        return this.zza.toString();
    }
}
