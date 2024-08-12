/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.core.location;

import android.location.Location;

private static class LocationCompat.Api18Impl {
    private LocationCompat.Api18Impl() {
    }

    static boolean isMock(Location location) {
        return location.isFromMockProvider();
    }
}
