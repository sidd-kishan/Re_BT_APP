/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.core.util.Consumer
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

public final class _$$Lambda$K8R1nxorC__fhJS80SsYrGI5qJg
implements Consumer {
    private final CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ _$$Lambda$K8R1nxorC__fhJS80SsYrGI5qJg(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void accept(Object object) {
        this.f$0.set((Object)((SurfaceRequest.Result)object));
    }
}
