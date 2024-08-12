/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$MetadataImageReader$8HL2vw_DsR0m0aXoFgsFnlVPkmY
implements Runnable {
    private final MetadataImageReader f$0;
    private final ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ _$$Lambda$MetadataImageReader$8HL2vw_DsR0m0aXoFgsFnlVPkmY(MetadataImageReader metadataImageReader, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = metadataImageReader;
        this.f$1 = onImageAvailableListener;
    }

    @Override
    public final void run() {
        this.f$0.lambda$enqueueImageProxy$1$MetadataImageReader(this.f$1);
    }
}
