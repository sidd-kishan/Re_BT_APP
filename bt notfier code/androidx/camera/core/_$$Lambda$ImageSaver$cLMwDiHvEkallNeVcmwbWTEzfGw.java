/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageSaver
 *  androidx.camera.core.ImageSaver$SaveError
 */
package androidx.camera.core;

import androidx.camera.core.ImageSaver;

public final class _$$Lambda$ImageSaver$cLMwDiHvEkallNeVcmwbWTEzfGw
implements Runnable {
    private final ImageSaver f$0;
    private final ImageSaver.SaveError f$1;
    private final String f$2;
    private final Throwable f$3;

    public /* synthetic */ _$$Lambda$ImageSaver$cLMwDiHvEkallNeVcmwbWTEzfGw(ImageSaver imageSaver, ImageSaver.SaveError saveError, String string, Throwable throwable) {
        this.f$0 = imageSaver;
        this.f$1 = saveError;
        this.f$2 = string;
        this.f$3 = throwable;
    }

    @Override
    public final void run() {
        this.f$0.lambda$postError$2$ImageSaver(this.f$1, this.f$2, this.f$3);
    }
}
