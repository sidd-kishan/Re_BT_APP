/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

class LocationManagerCompat.1
implements Runnable {
    final Consumer val$consumer;
    final Location val$location;

    LocationManagerCompat.1(Consumer consumer, Location location) {
        this.val$consumer = consumer;
        this.val$location = location;
    }

    @Override
    public void run() {
        this.val$consumer.accept((Object)this.val$location);
    }
}
