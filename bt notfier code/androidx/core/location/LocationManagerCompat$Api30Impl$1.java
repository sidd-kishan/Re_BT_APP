/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

class LocationManagerCompat.Api30Impl.1
implements Consumer<Location> {
    final androidx.core.util.Consumer val$consumer;

    LocationManagerCompat.Api30Impl.1(androidx.core.util.Consumer consumer) {
        this.val$consumer = consumer;
    }

    @Override
    public void accept(Location location) {
        this.val$consumer.accept((Object)location);
    }
}
