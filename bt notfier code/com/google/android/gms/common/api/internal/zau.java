/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zax
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zax;

final class zau
implements Runnable {
    final zax zaa;

    zau(zax zax2) {
        this.zaa = zax2;
    }

    @Override
    public final void run() {
        zax.zao((zax)this.zaa).lock();
        try {
            zax.zap((zax)this.zaa);
            return;
        }
        finally {
            zax.zao((zax)this.zaa).unlock();
        }
    }
}
