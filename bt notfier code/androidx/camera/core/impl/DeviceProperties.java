/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.camera.core.impl.AutoValue_DeviceProperties
 */
package androidx.camera.core.impl;

import android.os.Build;
import androidx.camera.core.impl.AutoValue_DeviceProperties;

public abstract class DeviceProperties {
    public static DeviceProperties create() {
        return DeviceProperties.create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    public static DeviceProperties create(String string, String string2, int n) {
        return new AutoValue_DeviceProperties(string, string2, n);
    }

    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();
}
