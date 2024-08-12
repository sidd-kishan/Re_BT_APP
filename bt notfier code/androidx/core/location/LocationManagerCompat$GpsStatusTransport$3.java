/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.location.LocationManagerCompat$GpsStatusTransport
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

class LocationManagerCompat.GpsStatusTransport.3
implements Runnable {
    final LocationManagerCompat.GpsStatusTransport this$0;
    final Executor val$executor;
    final int val$ttff;

    LocationManagerCompat.GpsStatusTransport.3(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int n) {
        this.this$0 = gpsStatusTransport;
        this.val$executor = executor;
        this.val$ttff = n;
    }

    @Override
    public void run() {
        if (this.this$0.mExecutor != this.val$executor) {
            return;
        }
        this.this$0.mCallback.onFirstFix(this.val$ttff);
    }
}
