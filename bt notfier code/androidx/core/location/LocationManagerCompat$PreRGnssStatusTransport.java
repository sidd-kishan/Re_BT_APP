/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 *  androidx.core.location.GnssStatusCompat$Callback
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

private static class LocationManagerCompat.PreRGnssStatusTransport
extends GnssStatus.Callback {
    final GnssStatusCompat.Callback mCallback;
    volatile Executor mExecutor;

    LocationManagerCompat.PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
        boolean bl = callback != null;
        Preconditions.checkArgument((boolean)bl, (Object)"invalid null callback");
        this.mCallback = callback;
    }

    public void onFirstFix(int n) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onStarted() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onStopped() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void register(Executor executor) {
        boolean bl = true;
        boolean bl2 = executor != null;
        Preconditions.checkArgument((boolean)bl2, (Object)"invalid null executor");
        bl2 = this.mExecutor == null ? bl : false;
        Preconditions.checkState((boolean)bl2);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}
