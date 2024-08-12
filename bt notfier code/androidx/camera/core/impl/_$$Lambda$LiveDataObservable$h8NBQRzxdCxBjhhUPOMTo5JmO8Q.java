/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable
 *  androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final class _$$Lambda$LiveDataObservable$h8NBQRzxdCxBjhhUPOMTo5JmO8Q
implements Runnable {
    private final LiveDataObservable f$0;
    private final LiveDataObservable.LiveDataObserverAdapter f$1;
    private final LiveDataObservable.LiveDataObserverAdapter f$2;

    public /* synthetic */ _$$Lambda$LiveDataObservable$h8NBQRzxdCxBjhhUPOMTo5JmO8Q(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter2) {
        this.f$0 = liveDataObservable;
        this.f$1 = liveDataObserverAdapter;
        this.f$2 = liveDataObserverAdapter2;
    }

    @Override
    public final void run() {
        this.f$0.lambda$addObserver$2$LiveDataObservable(this.f$1, this.f$2);
    }
}
