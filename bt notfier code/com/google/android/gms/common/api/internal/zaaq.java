/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.zaah
 *  com.google.android.gms.common.api.internal.zaar
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaah;
import com.google.android.gms.common.api.internal.zaar;

abstract class zaaq
implements Runnable {
    final zaar zab;

    /* synthetic */ zaaq(zaar zaar2, zaah zaah2) {
        this.zab = zaar2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void run() {
        block7: {
            block8: {
                zaar.zak((zaar)this.zab).lock();
                var1_1 = Thread.interrupted();
                if (var1_1) {
                }
                ** GOTO lbl-1000
                {
                    catch (Throwable var2_3) {
                        break block7;
                    }
                    catch (RuntimeException var2_4) {}
                    {
                        zaar.zal((zaar)this.zab).zas(var2_4);
                    }
                    var2_2 = zaar.zak((zaar)this.zab);
                    break block8;
                }
                var2_2 = zaar.zak((zaar)this.zab);
            }
lbl15:
            // 2 sources

            while (true) {
                var2_2.unlock();
                return;
            }
lbl-1000:
            // 1 sources

            {
                this.zaa();
            }
            var2_2 = zaar.zak((zaar)this.zab);
            ** while (true)
        }
        zaar.zak((zaar)this.zab).unlock();
        throw var2_3;
    }

    protected abstract void zaa();
}
