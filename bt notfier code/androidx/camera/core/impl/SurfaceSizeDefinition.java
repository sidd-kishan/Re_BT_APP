/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.impl.AutoValue_SurfaceSizeDefinition
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.AutoValue_SurfaceSizeDefinition;

public abstract class SurfaceSizeDefinition {
    SurfaceSizeDefinition() {
    }

    public static SurfaceSizeDefinition create(Size size, Size size2, Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }

    public abstract Size getAnalysisSize();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();
}
