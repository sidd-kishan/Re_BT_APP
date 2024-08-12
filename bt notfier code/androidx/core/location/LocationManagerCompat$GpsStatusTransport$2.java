/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.location.LocationManagerCompat$GpsStatusTransport
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

class LocationManagerCompat.GpsStatusTransport.2
implements Runnable {
    final LocationManagerCompat.GpsStatusTransport this$0;
    final Executor val$executor;

    LocationManagerCompat.GpsStatusTransport.2(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.this$0 = gpsStatusTransport;
        this.val$executor = executor;
    }

    @Override
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onStopped();
    }
}
