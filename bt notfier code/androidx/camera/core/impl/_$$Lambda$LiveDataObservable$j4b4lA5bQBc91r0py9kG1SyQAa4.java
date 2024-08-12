/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$LiveDataObservable$j4b4lA5bQBc91r0py9kG1SyQAa4
implements Runnable {
    private final LiveDataObservable f$0;
    private final CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ _$$Lambda$LiveDataObservable$j4b4lA5bQBc91r0py9kG1SyQAa4(LiveDataObservable liveDataObservable, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = liveDataObservable;
        this.f$1 = completer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$fetchData$0$LiveDataObservable(this.f$1);
    }
}
