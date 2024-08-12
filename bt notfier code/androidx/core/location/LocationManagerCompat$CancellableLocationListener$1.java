/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.core.location.LocationManagerCompat$CancellableLocationListener
 */
package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

class LocationManagerCompat.CancellableLocationListener.1
implements Runnable {
    final LocationManagerCompat.CancellableLocationListener this$0;

    LocationManagerCompat.CancellableLocationListener.1(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.this$0 = cancellableLocationListener;
    }

    @Override
    public void run() {
        this.this$0.mTimeoutRunnable = null;
        this.this$0.onLocationChanged((Location)null);
    }
}
