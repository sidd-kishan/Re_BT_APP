/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.utils.CameraOrientationUtil
 */
package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(UseCaseConfig.Builder<?, ?, ?> builder, int n) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig)builder.getUseCaseConfig();
        int n2 = imageOutputConfig.getTargetRotation(-1);
        if (n2 == -1 || n2 != n) {
            ((ImageOutputConfig.Builder)builder).setTargetRotation(n);
        }
        if (n2 == -1) return;
        if (n == -1) return;
        if (n2 == n) return;
        n2 = CameraOrientationUtil.surfaceRotationToDegrees((int)n2);
        if (Math.abs(CameraOrientationUtil.surfaceRotationToDegrees((int)n) - n2) % 180 != 90) return;
        if ((imageOutputConfig = imageOutputConfig.getTargetResolution(null)) == null) return;
        ((ImageOutputConfig.Builder)builder).setTargetResolution(new Size(imageOutputConfig.getHeight(), imageOutputConfig.getWidth()));
    }
}
