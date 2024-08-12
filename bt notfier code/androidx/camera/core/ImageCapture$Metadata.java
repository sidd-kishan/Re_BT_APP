/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.camera.core;

import android.location.Location;

public static final class ImageCapture.Metadata {
    private boolean mIsReversedHorizontal;
    private boolean mIsReversedHorizontalSet = false;
    private boolean mIsReversedVertical;
    private Location mLocation;

    public Location getLocation() {
        return this.mLocation;
    }

    public boolean isReversedHorizontal() {
        return this.mIsReversedHorizontal;
    }

    public boolean isReversedHorizontalSet() {
        return this.mIsReversedHorizontalSet;
    }

    public boolean isReversedVertical() {
        return this.mIsReversedVertical;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public void setReversedHorizontal(boolean bl) {
        this.mIsReversedHorizontal = bl;
        this.mIsReversedHorizontalSet = true;
    }

    public void setReversedVertical(boolean bl) {
        this.mIsReversedVertical = bl;
    }
}
