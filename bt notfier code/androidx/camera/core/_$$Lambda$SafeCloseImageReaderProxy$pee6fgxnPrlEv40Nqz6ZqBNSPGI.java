/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.SafeCloseImageReaderProxy
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SafeCloseImageReaderProxy;

public final class _$$Lambda$SafeCloseImageReaderProxy$pee6fgxnPrlEv40Nqz6ZqBNSPGI
implements ForwardingImageProxy.OnImageCloseListener {
    private final SafeCloseImageReaderProxy f$0;

    public /* synthetic */ _$$Lambda$SafeCloseImageReaderProxy$pee6fgxnPrlEv40Nqz6ZqBNSPGI(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f$0 = safeCloseImageReaderProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f$0.lambda$new$0$SafeCloseImageReaderProxy(imageProxy);
    }
}
