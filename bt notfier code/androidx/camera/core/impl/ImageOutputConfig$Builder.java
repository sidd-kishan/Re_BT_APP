/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import java.util.List;

public static interface ImageOutputConfig.Builder<B> {
    public B setDefaultResolution(Size var1);

    public B setMaxResolution(Size var1);

    public B setSupportedResolutions(List<Pair<Integer, Size[]>> var1);

    public B setTargetAspectRatio(int var1);

    public B setTargetResolution(Size var1);

    public B setTargetRotation(int var1);
}
