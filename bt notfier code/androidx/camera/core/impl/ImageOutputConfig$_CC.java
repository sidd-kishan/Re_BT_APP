/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.impl.ImageOutputConfig
 */
package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import java.util.List;

public final class ImageOutputConfig$_CC {
    public static Size $default$getDefaultResolution(ImageOutputConfig imageOutputConfig) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    public static Size $default$getDefaultResolution(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, (Object)size);
    }

    public static Size $default$getMaxResolution(ImageOutputConfig imageOutputConfig) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    public static Size $default$getMaxResolution(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, (Object)size);
    }

    public static List<Pair<Integer, Size[]>> $default$getSupportedResolutions(ImageOutputConfig imageOutputConfig) {
        return (List)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    public static List<Pair<Integer, Size[]>> $default$getSupportedResolutions(ImageOutputConfig imageOutputConfig, List<Pair<Integer, Size[]>> list) {
        return (List)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    public static int $default$getTargetAspectRatio(ImageOutputConfig imageOutputConfig) {
        return (Integer)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }

    public static Size $default$getTargetResolution(ImageOutputConfig imageOutputConfig) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }

    public static Size $default$getTargetResolution(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, (Object)size);
    }

    public static int $default$getTargetRotation(ImageOutputConfig imageOutputConfig) {
        return (Integer)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION);
    }

    public static int $default$getTargetRotation(ImageOutputConfig imageOutputConfig, int n) {
        return (Integer)imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, (Object)n);
    }

    public static boolean $default$hasTargetAspectRatio(ImageOutputConfig imageOutputConfig) {
        return imageOutputConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }
}
