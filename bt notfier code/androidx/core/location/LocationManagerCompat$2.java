/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.location.LocationManagerCompat$CancellableLocationListener
 *  androidx.core.os.CancellationSignal$OnCancelListener
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;

class LocationManagerCompat.2
implements CancellationSignal.OnCancelListener {
    final LocationManagerCompat.CancellableLocationListener val$listener;

    LocationManagerCompat.2(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.val$listener = cancellableLocationListener;
    }

    public void onCancel() {
        this.val$listener.cancel();
    }
}
