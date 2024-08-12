/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy$PlaneProxy
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;

public interface ImageProxy
extends AutoCloseable {
    @Override
    public void close();

    public Rect getCropRect();

    public int getFormat();

    public int getHeight();

    public Image getImage();

    public ImageInfo getImageInfo();

    public PlaneProxy[] getPlanes();

    public int getWidth();

    public void setCropRect(Rect var1);
}
