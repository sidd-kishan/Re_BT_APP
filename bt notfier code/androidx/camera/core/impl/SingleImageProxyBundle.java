/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public final class SingleImageProxyBundle
implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    SingleImageProxyBundle(ImageProxy imageProxy, int n) {
        this.mCaptureId = n;
        this.mImageProxy = imageProxy;
    }

    public SingleImageProxyBundle(ImageProxy imageProxy, String object) {
        ImageInfo imageInfo = imageProxy.getImageInfo();
        if (imageInfo == null) throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
        object = imageInfo.getTagBundle().getTag((String)object);
        if (object == null) throw new IllegalArgumentException("ImageProxy has no associated tag");
        this.mCaptureId = (Integer)object;
        this.mImageProxy = imageProxy;
    }

    public void close() {
        this.mImageProxy.close();
    }

    public List<Integer> getCaptureIds() {
        return Collections.singletonList(this.mCaptureId);
    }

    public ListenableFuture<ImageProxy> getImageProxy(int n) {
        if (n == this.mCaptureId) return Futures.immediateFuture((Object)this.mImageProxy);
        return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("Capture id does not exist in the bundle"));
    }
}
