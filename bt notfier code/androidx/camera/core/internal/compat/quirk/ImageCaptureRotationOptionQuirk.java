/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Quirk
 */
package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;

public final class ImageCaptureRotationOptionQuirk
implements Quirk {
    private static boolean isHonor9X() {
        boolean bl = "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
        return bl;
    }

    private static boolean isHuaweiMate20Lite() {
        boolean bl = "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
        return bl;
    }

    static boolean load() {
        boolean bl = ImageCaptureRotationOptionQuirk.isHuaweiMate20Lite() || ImageCaptureRotationOptionQuirk.isHonor9X();
        return bl;
    }

    public boolean isSupported(Config.Option<?> option) {
        boolean bl = option != CaptureConfig.OPTION_ROTATION;
        return bl;
    }
}
