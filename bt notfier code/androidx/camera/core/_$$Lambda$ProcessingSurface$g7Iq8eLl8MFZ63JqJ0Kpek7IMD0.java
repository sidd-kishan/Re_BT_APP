/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ProcessingSurface
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.impl.ImageReaderProxy;

public final class _$$Lambda$ProcessingSurface$g7Iq8eLl8MFZ63JqJ0Kpek7IMD0
implements ImageReaderProxy.OnImageAvailableListener {
    private final ProcessingSurface f$0;

    public /* synthetic */ _$$Lambda$ProcessingSurface$g7Iq8eLl8MFZ63JqJ0Kpek7IMD0(ProcessingSurface processingSurface) {
        this.f$0 = processingSurface;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f$0.lambda$new$0$ProcessingSurface(imageReaderProxy);
    }
}
