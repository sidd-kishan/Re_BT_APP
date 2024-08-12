/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  androidx.camera.core.impl.Quirk
 */
package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class SurfaceViewStretchedQuirk
implements Quirk {
    private static final String GALAXY_Z_FOLD_2 = "F2Q";
    private static final String SAMSUNG = "SAMSUNG";

    static boolean load() {
        boolean bl = SAMSUNG.equals(Build.MANUFACTURER.toUpperCase()) && GALAXY_Z_FOLD_2.equals(Build.DEVICE.toUpperCase());
        return bl;
    }
}
