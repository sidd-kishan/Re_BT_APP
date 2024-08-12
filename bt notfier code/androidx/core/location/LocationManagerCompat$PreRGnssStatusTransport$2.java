/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

class LocationManagerCompat.PreRGnssStatusTransport.2
implements Runnable {
    final LocationManagerCompat.PreRGnssStatusTransport this$0;
    final Executor val$executor;

    LocationManagerCompat.PreRGnssStatusTransport.2(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.this$0 = preRGnssStatusTransport;
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
