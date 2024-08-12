/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.os.Build$VERSION
 *  androidx.core.location.GnssStatusCompat
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

class GnssStatusWrapper
extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    GnssStatusWrapper(GnssStatus gnssStatus) {
        this.mWrapped = (GnssStatus)Preconditions.checkNotNull((Object)gnssStatus);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GnssStatusWrapper)) {
            return false;
        }
        object = (GnssStatusWrapper)((Object)object);
        return this.mWrapped.equals((Object)((GnssStatusWrapper)((Object)object)).mWrapped);
    }

    public float getAzimuthDegrees(int n) {
        return this.mWrapped.getAzimuthDegrees(n);
    }

    public float getBasebandCn0DbHz(int n) {
        if (Build.VERSION.SDK_INT < 30) throw new UnsupportedOperationException();
        return this.mWrapped.getBasebandCn0DbHz(n);
    }

    public float getCarrierFrequencyHz(int n) {
        if (Build.VERSION.SDK_INT < 26) throw new UnsupportedOperationException();
        return this.mWrapped.getCarrierFrequencyHz(n);
    }

    public float getCn0DbHz(int n) {
        return this.mWrapped.getCn0DbHz(n);
    }

    public int getConstellationType(int n) {
        return this.mWrapped.getConstellationType(n);
    }

    public float getElevationDegrees(int n) {
        return this.mWrapped.getElevationDegrees(n);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int n) {
        return this.mWrapped.getSvid(n);
    }

    public boolean hasAlmanacData(int n) {
        return this.mWrapped.hasAlmanacData(n);
    }

    public boolean hasBasebandCn0DbHz(int n) {
        if (Build.VERSION.SDK_INT < 30) return false;
        return this.mWrapped.hasBasebandCn0DbHz(n);
    }

    public boolean hasCarrierFrequencyHz(int n) {
        if (Build.VERSION.SDK_INT < 26) return false;
        return this.mWrapped.hasCarrierFrequencyHz(n);
    }

    public boolean hasEphemerisData(int n) {
        return this.mWrapped.hasEphemerisData(n);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int n) {
        return this.mWrapped.usedInFix(n);
    }
}
