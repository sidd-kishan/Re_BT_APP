/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeviceProperties
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeviceProperties;

final class AutoValue_DeviceProperties
extends DeviceProperties {
    private final String manufacturer;
    private final String model;
    private final int sdkVersion;

    AutoValue_DeviceProperties(String string, String string2, int n) {
        if (string == null) throw new NullPointerException("Null manufacturer");
        this.manufacturer = string;
        if (string2 == null) throw new NullPointerException("Null model");
        this.model = string2;
        this.sdkVersion = n;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof DeviceProperties)) return false;
        if (this.manufacturer.equals((object = (DeviceProperties)object).manufacturer()) && this.model.equals(object.model()) && this.sdkVersion == object.sdkVersion()) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        return ((this.manufacturer.hashCode() ^ 0xF4243) * 1000003 ^ this.model.hashCode()) * 1000003 ^ this.sdkVersion;
    }

    public String manufacturer() {
        return this.manufacturer;
    }

    public String model() {
        return this.model;
    }

    public int sdkVersion() {
        return this.sdkVersion;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceProperties{manufacturer=");
        stringBuilder.append(this.manufacturer);
        stringBuilder.append(", model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", sdkVersion=");
        stringBuilder.append(this.sdkVersion);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
