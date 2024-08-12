/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ProcessingImageReader$2
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$ProcessingImageReader$2$Absc6rRf6C4HWC5BIoaUAtQpadI
implements Runnable {
    private final ProcessingImageReader.2 f$0;
    private final ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ _$$Lambda$ProcessingImageReader$2$Absc6rRf6C4HWC5BIoaUAtQpadI(ProcessingImageReader.2 var1_1, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = var1_1;
        this.f$1 = onImageAvailableListener;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onImageAvailable$0$ProcessingImageReader$2(this.f$1);
    }
}
