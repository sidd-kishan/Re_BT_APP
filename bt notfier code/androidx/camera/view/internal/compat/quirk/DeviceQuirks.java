/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Quirk
 *  androidx.camera.core.impl.Quirks
 *  androidx.camera.view.internal.compat.quirk.DeviceQuirksLoader
 */
package androidx.camera.view.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.view.internal.compat.quirk.DeviceQuirksLoader;

public class DeviceQuirks {
    private static final Quirks QUIRKS = new Quirks(DeviceQuirksLoader.loadQuirks());

    private DeviceQuirks() {
    }

    public static <T extends Quirk> T get(Class<T> clazz) {
        return (T)QUIRKS.get(clazz);
    }
}
