/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaba
 *  com.google.android.gms.common.api.internal.zabd
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaba;
import com.google.android.gms.common.api.internal.zabd;

abstract class zabb {
    private final zaba zaa;

    protected zabb(zaba zaba2) {
        this.zaa = zaba2;
    }

    protected abstract void zaa();

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zab(zabd object) {
        block4: {
            block3: {
                zabd.zat((zabd)object).lock();
                try {
                    zaba zaba2 = zabd.zau((zabd)object);
                    zaba zaba3 = this.zaa;
                    if (zaba2 == zaba3) break block3;
                }
                catch (Throwable throwable) {
                    zabd.zat((zabd)object).unlock();
                    throw throwable;
                }
                object = zabd.zat((zabd)object);
                break block4;
            }
            this.zaa();
            object = zabd.zat((zabd)object);
        }
        object.unlock();
    }
}
