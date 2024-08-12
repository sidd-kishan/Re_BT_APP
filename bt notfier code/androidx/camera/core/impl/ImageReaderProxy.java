/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

public interface ImageReaderProxy {
    public ImageProxy acquireLatestImage();

    public ImageProxy acquireNextImage();

    public void clearOnImageAvailableListener();

    public void close();

    public int getHeight();

    public int getImageFormat();

    public int getMaxImages();

    public Surface getSurface();

    public int getWidth();

    public void setOnImageAvailableListener(OnImageAvailableListener var1, Executor var2);
}
