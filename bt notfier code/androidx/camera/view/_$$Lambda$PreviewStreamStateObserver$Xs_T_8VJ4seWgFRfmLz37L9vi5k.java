/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.view.PreviewStreamStateObserver
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final class _$$Lambda$PreviewStreamStateObserver$Xs_T_8VJ4seWgFRfmLz37L9vi5k
implements CallbackToFutureAdapter.Resolver {
    private final PreviewStreamStateObserver f$0;
    private final CameraInfo f$1;
    private final List f$2;

    public /* synthetic */ _$$Lambda$PreviewStreamStateObserver$Xs_T_8VJ4seWgFRfmLz37L9vi5k(PreviewStreamStateObserver previewStreamStateObserver, CameraInfo cameraInfo, List list) {
        this.f$0 = previewStreamStateObserver;
        this.f$1 = cameraInfo;
        this.f$2 = list;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$waitForCaptureResult$2$PreviewStreamStateObserver(this.f$1, this.f$2, completer);
    }
}
