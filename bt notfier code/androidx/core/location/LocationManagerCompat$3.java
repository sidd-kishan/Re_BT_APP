/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GpsStatus$Listener
 *  android.location.LocationManager
 *  androidx.core.location.LocationManagerCompat$GpsStatusTransport
 */
package androidx.core.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

class LocationManagerCompat.3
implements Callable<Boolean> {
    final LocationManager val$locationManager;
    final LocationManagerCompat.GpsStatusTransport val$myTransport;

    LocationManagerCompat.3(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.val$locationManager = locationManager;
        this.val$myTransport = gpsStatusTransport;
    }

    @Override
    public Boolean call() {
        return this.val$locationManager.addGpsStatusListener((GpsStatus.Listener)this.val$myTransport);
    }
}
