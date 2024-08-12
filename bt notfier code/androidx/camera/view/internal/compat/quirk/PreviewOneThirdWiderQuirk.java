/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.camera.core.impl.Quirk
 */
package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class PreviewOneThirdWiderQuirk
implements Quirk {
    private static final String SAMSUNG_A3_2017 = "A3Y17LTE";
    private static final String SAMSUNG_J5_PRIME = "ON5XELTE";

    static boolean load() {
        boolean bl = SAMSUNG_J5_PRIME.equals(Build.DEVICE.toUpperCase());
        boolean bl2 = true;
        boolean bl3 = bl && Build.VERSION.SDK_INT >= 26;
        boolean bl4 = SAMSUNG_A3_2017.equals(Build.DEVICE.toUpperCase());
        bl = bl2;
        if (bl3) return bl;
        bl = bl4 ? bl2 : false;
        return bl;
    }

    public float getCropRectScaleX() {
        return 0.75f;
    }
}
