/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.AutoValue_ImmutableImageInfo
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_ImmutableImageInfo;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

abstract class ImmutableImageInfo
implements ImageInfo {
    ImmutableImageInfo() {
    }

    public static ImageInfo create(TagBundle tagBundle, long l, int n) {
        return new AutoValue_ImmutableImageInfo(tagBundle, l, n);
    }

    public abstract int getRotationDegrees();

    public abstract TagBundle getTagBundle();

    public abstract long getTimestamp();

    public void populateExifData(ExifData.Builder builder) {
        builder.setOrientationDegrees(this.getRotationDegrees());
    }
}
