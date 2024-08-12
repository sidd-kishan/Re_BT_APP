/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;

final class SingleCloseImageProxy
extends ForwardingImageProxy {
    private boolean mClosed = false;

    SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
    }

    public void close() {
        synchronized (this) {
            if (this.mClosed) return;
            this.mClosed = true;
            super.close();
            return;
        }
    }
}
