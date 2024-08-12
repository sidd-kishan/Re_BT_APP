/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  androidx.core.location.GnssStatusCompat
 *  androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

class LocationManagerCompat.PreRGnssStatusTransport.4
implements Runnable {
    final LocationManagerCompat.PreRGnssStatusTransport this$0;
    final Executor val$executor;
    final GnssStatus val$status;

    LocationManagerCompat.PreRGnssStatusTransport.4(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.this$0 = preRGnssStatusTransport;
        this.val$executor = executor;
        this.val$status = gnssStatus;
    }

    @Override
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap((GnssStatus)this.val$status));
    }
}
