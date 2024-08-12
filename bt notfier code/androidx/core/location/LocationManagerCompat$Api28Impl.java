/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.LocationManager
 */
package androidx.core.location;

import android.location.LocationManager;

private static class LocationManagerCompat.Api28Impl {
    private LocationManagerCompat.Api28Impl() {
    }

    static String getGnssHardwareModelName(LocationManager locationManager) {
        return locationManager.getGnssHardwareModelName();
    }

    static int getGnssYearOfHardware(LocationManager locationManager) {
        return locationManager.getGnssYearOfHardware();
    }

    static boolean isLocationEnabled(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }
}
