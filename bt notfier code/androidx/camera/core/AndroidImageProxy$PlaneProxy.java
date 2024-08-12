/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.Image$Plane
 *  androidx.camera.core.ImageProxy$PlaneProxy
 */
package androidx.camera.core;

import android.media.Image;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

private static final class AndroidImageProxy.PlaneProxy
implements ImageProxy.PlaneProxy {
    private final Image.Plane mPlane;

    AndroidImageProxy.PlaneProxy(Image.Plane plane) {
        this.mPlane = plane;
    }

    public ByteBuffer getBuffer() {
        synchronized (this) {
            ByteBuffer byteBuffer = this.mPlane.getBuffer();
            return byteBuffer;
        }
    }

    public int getPixelStride() {
        synchronized (this) {
            int n = this.mPlane.getPixelStride();
            return n;
        }
    }

    public int getRowStride() {
        synchronized (this) {
            int n = this.mPlane.getRowStride();
            return n;
        }
    }
}
