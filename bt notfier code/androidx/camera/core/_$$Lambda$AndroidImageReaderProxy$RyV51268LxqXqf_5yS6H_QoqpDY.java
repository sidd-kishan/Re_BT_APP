/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$AndroidImageReaderProxy$RyV51268LxqXqf_5yS6H_QoqpDY
implements Runnable {
    private final AndroidImageReaderProxy f$0;
    private final ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ _$$Lambda$AndroidImageReaderProxy$RyV51268LxqXqf_5yS6H_QoqpDY(AndroidImageReaderProxy androidImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = androidImageReaderProxy;
        this.f$1 = onImageAvailableListener;
    }

    @Override
    public final void run() {
        this.f$0.lambda$setOnImageAvailableListener$0$AndroidImageReaderProxy(this.f$1);
    }
}
