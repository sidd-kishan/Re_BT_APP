/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GpsStatus
 *  android.location.GpsStatus$Listener
 *  android.location.LocationManager
 *  androidx.core.location.GnssStatusCompat$Callback
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

private static class LocationManagerCompat.GpsStatusTransport
implements GpsStatus.Listener {
    final GnssStatusCompat.Callback mCallback;
    volatile Executor mExecutor;
    private final LocationManager mLocationManager;

    LocationManagerCompat.GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        boolean bl = callback != null;
        Preconditions.checkArgument((boolean)bl, (Object)"invalid null callback");
        this.mLocationManager = locationManager;
        this.mCallback = callback;
    }

    public void onGpsStatusChanged(int n) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) return;
                    GpsStatus gpsStatus = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus == null) return;
                    executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    GpsStatus gpsStatus = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus == null) return;
                    executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
                }
            } else {
                executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            }
        } else {
            executor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public void register(Executor executor) {
        boolean bl = this.mExecutor == null;
        Preconditions.checkState((boolean)bl);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}
