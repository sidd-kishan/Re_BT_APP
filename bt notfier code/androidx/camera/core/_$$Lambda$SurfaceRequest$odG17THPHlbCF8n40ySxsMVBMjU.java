/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final class _$$Lambda$SurfaceRequest$odG17THPHlbCF8n40ySxsMVBMjU
implements CallbackToFutureAdapter.Resolver {
    private final AtomicReference f$0;
    private final String f$1;

    public /* synthetic */ _$$Lambda$SurfaceRequest$odG17THPHlbCF8n40ySxsMVBMjU(AtomicReference atomicReference, String string) {
        this.f$0 = atomicReference;
        this.f$1 = string;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return SurfaceRequest.lambda$new$0((AtomicReference)this.f$0, (String)this.f$1, (CallbackToFutureAdapter.Completer)completer);
    }
}
