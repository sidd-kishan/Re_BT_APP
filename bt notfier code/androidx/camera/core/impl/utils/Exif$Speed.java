/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.Exif$Speed$Converter
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.Exif;

private static final class Exif.Speed {
    private Exif.Speed() {
    }

    static Converter fromKilometersPerHour(double d) {
        return new Converter(d * 0.621371);
    }

    static Converter fromKnots(double d) {
        return new Converter(d * 1.15078);
    }

    static Converter fromMetersPerSecond(double d) {
        return new Converter(d * 2.23694);
    }

    static Converter fromMilesPerHour(double d) {
        return new Converter(d);
    }
}
