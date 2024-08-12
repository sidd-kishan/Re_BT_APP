/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaai
implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference<zaar> zaa;
    private final Api<?> zab;
    private final boolean zac;

    public zaai(zaar zaar2, Api<?> api, boolean bl) {
        this.zaa = new WeakReference<zaar>(zaar2);
        this.zab = api;
        this.zac = bl;
    }

    static /* synthetic */ boolean zaa(zaai zaai2) {
        return zaai2.zac;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onReportServiceBinding(ConnectionResult object) {
        block7: {
            zaar zaar2;
            block6: {
                block5: {
                    zaar2 = (zaar)this.zaa.get();
                    if (zaar2 == null) {
                        return;
                    }
                    boolean bl = Looper.myLooper() == zaar.zal((zaar)zaar2).zag.getLooper();
                    Preconditions.checkState((boolean)bl, (Object)"onReportServiceBinding must be called on the GoogleApiClient handler thread");
                    zaar.zak((zaar)zaar2).lock();
                    try {
                        bl = zaar.zav((zaar)zaar2, (int)0);
                        if (bl) break block5;
                    }
                    catch (Throwable throwable) {
                        zaar.zak((zaar)zaar2).unlock();
                        throw throwable;
                    }
                    object = zaar.zak((zaar)zaar2);
                    break block7;
                }
                if (!object.isSuccess()) {
                    zaar.zaw((zaar)zaar2, (ConnectionResult)object, this.zab, (boolean)this.zac);
                }
                if (!zaar.zax((zaar)zaar2)) break block6;
                zaar.zau((zaar)zaar2);
            }
            object = zaar.zak((zaar)zaar2);
        }
        object.unlock();
    }
}
