/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageSaver
 */
package androidx.camera.core;

import androidx.camera.core.ImageSaver;
import java.io.File;

public final class _$$Lambda$ImageSaver$AirN55SwcszagHg1aVwvl21IDMo
implements Runnable {
    private final ImageSaver f$0;
    private final File f$1;

    public /* synthetic */ _$$Lambda$ImageSaver$AirN55SwcszagHg1aVwvl21IDMo(ImageSaver imageSaver, File file) {
        this.f$0 = imageSaver;
        this.f$1 = file;
    }

    @Override
    public final void run() {
        this.f$0.lambda$run$0$ImageSaver(this.f$1);
    }
}
