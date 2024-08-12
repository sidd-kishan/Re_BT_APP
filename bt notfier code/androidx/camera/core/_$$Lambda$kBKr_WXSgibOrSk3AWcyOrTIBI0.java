/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SafeCloseImageReaderProxy
 */
package androidx.camera.core;

import androidx.camera.core.SafeCloseImageReaderProxy;

public final class _$$Lambda$kBKr_WXSgibOrSk3AWcyOrTIBI0
implements Runnable {
    private final SafeCloseImageReaderProxy f$0;

    public /* synthetic */ _$$Lambda$kBKr_WXSgibOrSk3AWcyOrTIBI0(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f$0 = safeCloseImageReaderProxy;
    }

    @Override
    public final void run() {
        this.f$0.safeClose();
    }
}
