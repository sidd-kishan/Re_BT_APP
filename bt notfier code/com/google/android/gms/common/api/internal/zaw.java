/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.internal.zabt
 *  com.google.android.gms.common.api.internal.zau
 *  com.google.android.gms.common.api.internal.zax
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zau;
import com.google.android.gms.common.api.internal.zax;
import java.util.concurrent.locks.Lock;

final class zaw
implements zabt {
    final zax zaa;

    /* synthetic */ zaw(zax zax2, zau zau2) {
        this.zaa = zax2;
    }

    public final void zaa(Bundle bundle) {
        zax.zao((zax)this.zaa).lock();
        try {
            zax.zax((zax)this.zaa, (ConnectionResult)ConnectionResult.RESULT_SUCCESS);
            zax.zap((zax)this.zaa);
            return;
        }
        finally {
            zax.zao((zax)this.zaa).unlock();
        }
    }

    public final void zab(ConnectionResult connectionResult) {
        zax.zao((zax)this.zaa).lock();
        try {
            zax.zax((zax)this.zaa, (ConnectionResult)connectionResult);
            zax.zap((zax)this.zaa);
            return;
        }
        finally {
            zax.zao((zax)this.zaa).unlock();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zac(int n, boolean bl) {
        Lock lock;
        block4: {
            block3: {
                zax.zao((zax)this.zaa).lock();
                try {
                    if (!zax.zas((zax)this.zaa)) break block3;
                    zax.zau((zax)this.zaa, (boolean)false);
                    zax.zav((zax)this.zaa, (int)n, (boolean)bl);
                }
                catch (Throwable throwable) {
                    zax.zao((zax)this.zaa).unlock();
                    throw throwable;
                }
                lock = zax.zao((zax)this.zaa);
                break block4;
            }
            zax.zau((zax)this.zaa, (boolean)true);
            zax.zay((zax)this.zaa).onConnectionSuspended(n);
            lock = zax.zao((zax)this.zaa);
        }
        lock.unlock();
    }
}
