/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$MetadataImageReader$DONJ_Tb_b_WYV8EceE_yMZTG_HA
implements ImageReaderProxy.OnImageAvailableListener {
    private final MetadataImageReader f$0;

    public /* synthetic */ _$$Lambda$MetadataImageReader$DONJ_Tb_b_WYV8EceE_yMZTG_HA(MetadataImageReader metadataImageReader) {
        this.f$0 = metadataImageReader;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f$0.lambda$new$0$MetadataImageReader(imageReaderProxy);
    }
}
