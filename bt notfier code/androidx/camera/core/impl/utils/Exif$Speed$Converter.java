/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

static final class Exif.Speed.Converter {
    final double mMph;

    Exif.Speed.Converter(double d) {
        this.mMph = d;
    }

    double toKilometersPerHour() {
        return this.mMph / 0.621371;
    }

    double toKnots() {
        return this.mMph / 1.15078;
    }

    double toMetersPerSecond() {
        return this.mMph / 2.23694;
    }

    double toMilesPerHour() {
        return this.mMph;
    }
}
