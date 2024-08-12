/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$DeferrableSurface$4AwivYkWbX9ifTwpoNEQg994K4I
implements CallbackToFutureAdapter.Resolver {
    private final DeferrableSurface f$0;

    public /* synthetic */ _$$Lambda$DeferrableSurface$4AwivYkWbX9ifTwpoNEQg994K4I(DeferrableSurface deferrableSurface) {
        this.f$0 = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$new$0$DeferrableSurface(completer);
    }
}
