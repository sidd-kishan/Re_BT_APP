/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.core.location.LocationManagerCompat$CancellableLocationListener
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;

class LocationManagerCompat.CancellableLocationListener.2
implements Runnable {
    final LocationManagerCompat.CancellableLocationListener this$0;
    final Consumer val$consumer;
    final Location val$location;

    LocationManagerCompat.CancellableLocationListener.2(LocationManagerCompat.CancellableLocationListener cancellableLocationListener, Consumer consumer, Location location) {
        this.this$0 = cancellableLocationListener;
        this.val$consumer = consumer;
        this.val$location = location;
    }

    @Override
    public void run() {
        this.val$consumer.accept((Object)this.val$location);
    }
}
