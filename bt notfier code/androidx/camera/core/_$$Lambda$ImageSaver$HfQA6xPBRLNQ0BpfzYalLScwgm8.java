/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.camera.core.ImageSaver
 */
package androidx.camera.core;

import android.net.Uri;
import androidx.camera.core.ImageSaver;

public final class _$$Lambda$ImageSaver$HfQA6xPBRLNQ0BpfzYalLScwgm8
implements Runnable {
    private final ImageSaver f$0;
    private final Uri f$1;

    public /* synthetic */ _$$Lambda$ImageSaver$HfQA6xPBRLNQ0BpfzYalLScwgm8(ImageSaver imageSaver, Uri uri) {
        this.f$0 = imageSaver;
        this.f$1 = uri;
    }

    @Override
    public final void run() {
        this.f$0.lambda$postSuccess$1$ImageSaver(this.f$1);
    }
}
