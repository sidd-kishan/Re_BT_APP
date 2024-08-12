/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.AspectRatio
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ReadableConfig
 */
package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.List;

public interface ImageOutputConfig
extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION;
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION;
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS;
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO;
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION;
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION;

    static {
        OPTION_TARGET_ASPECT_RATIO = Config.Option.create((String)"camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
        OPTION_TARGET_ROTATION = Config.Option.create((String)"camerax.core.imageOutput.targetRotation", Integer.TYPE);
        OPTION_TARGET_RESOLUTION = Config.Option.create((String)"camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config.Option.create((String)"camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config.Option.create((String)"camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create((String)"camerax.core.imageOutput.supportedResolutions", List.class);
    }

    public Size getDefaultResolution();

    public Size getDefaultResolution(Size var1);

    public Size getMaxResolution();

    public Size getMaxResolution(Size var1);

    public List<Pair<Integer, Size[]>> getSupportedResolutions();

    public List<Pair<Integer, Size[]>> getSupportedResolutions(List<Pair<Integer, Size[]>> var1);

    public int getTargetAspectRatio();

    public Size getTargetResolution();

    public Size getTargetResolution(Size var1);

    public int getTargetRotation();

    public int getTargetRotation(int var1);

    public boolean hasTargetAspectRatio();
}
