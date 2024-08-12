/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  androidx.camera.core.VideoCapture
 */
package androidx.camera.core;

import android.media.MediaCodec;
import androidx.camera.core.VideoCapture;

public final class _$$Lambda$VideoCapture$5Thc_jl34dkc10u5dmeCfXccSQI
implements Runnable {
    private final boolean f$0;
    private final MediaCodec f$1;

    public /* synthetic */ _$$Lambda$VideoCapture$5Thc_jl34dkc10u5dmeCfXccSQI(boolean bl, MediaCodec mediaCodec) {
        this.f$0 = bl;
        this.f$1 = mediaCodec;
    }

    @Override
    public final void run() {
        VideoCapture.lambda$releaseCameraSurface$7((boolean)this.f$0, (MediaCodec)this.f$1);
    }
}
