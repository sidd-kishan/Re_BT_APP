/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SafeCloseImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$SafeCloseImageReaderProxy$VO_yHRAHpdG2MqCxQDiZeplGJKU
implements ImageReaderProxy.OnImageAvailableListener {
    private final SafeCloseImageReaderProxy f$0;
    private final ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ _$$Lambda$SafeCloseImageReaderProxy$VO_yHRAHpdG2MqCxQDiZeplGJKU(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = safeCloseImageReaderProxy;
        this.f$1 = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f$0.lambda$setOnImageAvailableListener$1$SafeCloseImageReaderProxy(this.f$1, imageReaderProxy);
    }
}
