/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.core.location;

import android.location.Location;

private static class LocationCompat.Api17Impl {
    private LocationCompat.Api17Impl() {
    }

    static long getElapsedRealtimeNanos(Location location) {
        return location.getElapsedRealtimeNanos();
    }
}
