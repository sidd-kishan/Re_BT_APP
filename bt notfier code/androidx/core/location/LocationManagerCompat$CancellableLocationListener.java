/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.location.LocationManagerCompat$CancellableLocationListener$1
 *  androidx.core.util.Consumer
 */
package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

private static final class LocationManagerCompat.CancellableLocationListener
implements LocationListener {
    private Consumer<Location> mConsumer;
    private final Executor mExecutor;
    private final LocationManager mLocationManager;
    private final Handler mTimeoutHandler;
    Runnable mTimeoutRunnable;
    private boolean mTriggered;

    LocationManagerCompat.CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
        this.mLocationManager = locationManager;
        this.mExecutor = executor;
        this.mTimeoutHandler = new Handler(Looper.getMainLooper());
        this.mConsumer = consumer;
    }

    private void cleanup() {
        this.mConsumer = null;
        this.mLocationManager.removeUpdates((LocationListener)this);
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable == null) return;
        this.mTimeoutHandler.removeCallbacks(runnable);
        this.mTimeoutRunnable = null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void cancel() {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            this.mTriggered = true;
        }
        this.cleanup();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onLocationChanged(Location location) {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            this.mTriggered = true;
        }
        Consumer<Location> consumer = this.mConsumer;
        this.mExecutor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        this.cleanup();
    }

    public void onProviderDisabled(String string) {
        this.onLocationChanged(null);
    }

    public void onProviderEnabled(String string) {
    }

    public void onStatusChanged(String string, int n, Bundle bundle) {
    }

    public void startTimeout(long l) {
        synchronized (this) {
            if (this.mTriggered) {
                return;
            }
            1 var3_2 = new /* Unavailable Anonymous Inner Class!! */;
            this.mTimeoutRunnable = var3_2;
            this.mTimeoutHandler.postDelayed((Runnable)var3_2, l);
            return;
        }
    }
}
