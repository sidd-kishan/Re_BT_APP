/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ImageCapture.5
implements ThreadFactory {
    private final AtomicInteger mId;
    final ImageCapture this$0;

    ImageCapture.5(ImageCapture imageCapture) {
        this.this$0 = imageCapture;
        this.mId = new AtomicInteger(0);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraX-image_capture_");
        stringBuilder.append(this.mId.getAndIncrement());
        return new Thread(runnable, stringBuilder.toString());
    }
}
