/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.location.GnssStatusCompat
 *  androidx.core.location.LocationManagerCompat$GpsStatusTransport
 */
package androidx.core.location;

import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

class LocationManagerCompat.GpsStatusTransport.4
implements Runnable {
    final LocationManagerCompat.GpsStatusTransport this$0;
    final Executor val$executor;
    final GnssStatusCompat val$gnssStatus;

    LocationManagerCompat.GpsStatusTransport.4(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.this$0 = gpsStatusTransport;
        this.val$executor = executor;
        this.val$gnssStatus = gnssStatusCompat;
    }

    @Override
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onSatelliteStatusChanged(this.val$gnssStatus);
    }
}
