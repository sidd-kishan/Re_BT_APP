/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 *  androidx.core.location.GnssStatusCompat
 *  androidx.core.location.GnssStatusCompat$Callback
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

private static class LocationManagerCompat.GnssStatusTransport
extends GnssStatus.Callback {
    final GnssStatusCompat.Callback mCallback;

    LocationManagerCompat.GnssStatusTransport(GnssStatusCompat.Callback callback) {
        boolean bl = callback != null;
        Preconditions.checkArgument((boolean)bl, (Object)"invalid null callback");
        this.mCallback = callback;
    }

    public void onFirstFix(int n) {
        this.mCallback.onFirstFix(n);
    }

    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap((GnssStatus)gnssStatus));
    }

    public void onStarted() {
        this.mCallback.onStarted();
    }

    public void onStopped() {
        this.mCallback.onStopped();
    }
}
