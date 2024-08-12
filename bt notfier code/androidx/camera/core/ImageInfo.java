/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core;

import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

public interface ImageInfo {
    public int getRotationDegrees();

    public TagBundle getTagBundle();

    public long getTimestamp();

    public void populateExifData(ExifData.Builder var1);
}
