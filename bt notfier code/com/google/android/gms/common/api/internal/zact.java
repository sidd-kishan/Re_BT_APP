/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultTransform
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.zacv
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.internal.Preconditions;

final class zact
implements Runnable {
    final Result zaa;
    final zacv zab;

    zact(zacv zacv2, Result result) {
        this.zab = zacv2;
        this.zaa = result;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void run() {
        Throwable throwable2;
        block5: {
            PendingResult pendingResult;
            block6: {
                BasePendingResult.zaa.set(true);
                pendingResult = ((ResultTransform)Preconditions.checkNotNull((Object)zacv.zac((zacv)this.zab))).onSuccess(this.zaa);
                zacv.zad((zacv)this.zab).sendMessage(zacv.zad((zacv)this.zab).obtainMessage(0, (Object)pendingResult));
                {
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    catch (RuntimeException runtimeException) {}
                    {
                        zacv.zad((zacv)this.zab).sendMessage(zacv.zad((zacv)this.zab).obtainMessage(1, (Object)runtimeException));
                        BasePendingResult.zaa.set(false);
                    }
                    zacv.zae((zacv)this.zab, (Result)this.zaa);
                    pendingResult = (GoogleApiClient)zacv.zaf((zacv)this.zab).get();
                    if (pendingResult == null) return;
                    break block6;
                }
                BasePendingResult.zaa.set(false);
                zacv.zae((zacv)this.zab, (Result)this.zaa);
                pendingResult = (GoogleApiClient)zacv.zaf((zacv)this.zab).get();
                if (pendingResult == null) return;
            }
            pendingResult.zap(this.zab);
            return;
        }
        BasePendingResult.zaa.set(false);
        zacv.zae((zacv)this.zab, (Result)this.zaa);
        GoogleApiClient googleApiClient = (GoogleApiClient)zacv.zaf((zacv)this.zab).get();
        if (googleApiClient == null) {
            throw throwable2;
        }
        googleApiClient.zap(this.zab);
        throw throwable2;
    }
}
