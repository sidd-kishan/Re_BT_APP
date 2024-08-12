/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.view.PreviewStreamStateObserver
 */
package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.view.PreviewStreamStateObserver;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$PreviewStreamStateObserver$W_AFYrLTx1dowMs6tBeQNGMvooA
implements AsyncFunction {
    private final PreviewStreamStateObserver f$0;

    public /* synthetic */ _$$Lambda$PreviewStreamStateObserver$W_AFYrLTx1dowMs6tBeQNGMvooA(PreviewStreamStateObserver previewStreamStateObserver) {
        this.f$0 = previewStreamStateObserver;
    }

    public final ListenableFuture apply(Object object) {
        return this.f$0.lambda$startPreviewStreamStateFlow$0$PreviewStreamStateObserver((Void)object);
    }
}
