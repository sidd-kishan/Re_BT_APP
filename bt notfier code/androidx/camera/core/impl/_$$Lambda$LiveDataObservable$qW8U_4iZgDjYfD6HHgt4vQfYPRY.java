/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$LiveDataObservable$qW8U_4iZgDjYfD6HHgt4vQfYPRY
implements CallbackToFutureAdapter.Resolver {
    private final LiveDataObservable f$0;

    public /* synthetic */ _$$Lambda$LiveDataObservable$qW8U_4iZgDjYfD6HHgt4vQfYPRY(LiveDataObservable liveDataObservable) {
        this.f$0 = liveDataObservable;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$fetchData$1$LiveDataObservable(completer);
    }
}
