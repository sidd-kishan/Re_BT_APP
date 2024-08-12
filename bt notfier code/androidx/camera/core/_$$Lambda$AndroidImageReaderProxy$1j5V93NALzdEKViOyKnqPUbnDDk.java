/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

public final class _$$Lambda$AndroidImageReaderProxy$1j5V93NALzdEKViOyKnqPUbnDDk
implements ImageReader.OnImageAvailableListener {
    private final AndroidImageReaderProxy f$0;
    private final Executor f$1;
    private final ImageReaderProxy.OnImageAvailableListener f$2;

    public /* synthetic */ _$$Lambda$AndroidImageReaderProxy$1j5V93NALzdEKViOyKnqPUbnDDk(AndroidImageReaderProxy androidImageReaderProxy, Executor executor, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = androidImageReaderProxy;
        this.f$1 = executor;
        this.f$2 = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.f$0.lambda$setOnImageAvailableListener$1$AndroidImageReaderProxy(this.f$1, this.f$2, imageReader);
    }
}
