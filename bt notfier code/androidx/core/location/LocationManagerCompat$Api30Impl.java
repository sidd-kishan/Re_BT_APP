/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationManager
 *  android.os.CancellationSignal
 *  androidx.core.os.CancellationSignal
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.location.Location;
import android.location.LocationManager;
import androidx.core.os.CancellationSignal;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

private static class LocationManagerCompat.Api30Impl {
    private LocationManagerCompat.Api30Impl() {
    }

    static void getCurrentLocation(LocationManager locationManager, String string, CancellationSignal object, Executor executor, androidx.core.util.Consumer<Location> consumer) {
        object = object != null ? (android.os.CancellationSignal)object.getCancellationSignalObject() : null;
        locationManager.getCurrentLocation(string, (android.os.CancellationSignal)object, executor, (Consumer)new /* Unavailable Anonymous Inner Class!! */);
    }
}
