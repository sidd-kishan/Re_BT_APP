/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable
 *  androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final class _$$Lambda$LiveDataObservable$wtQDCfFf1Ih5nHx5_ovHcE5BosE
implements Runnable {
    private final LiveDataObservable f$0;
    private final LiveDataObservable.LiveDataObserverAdapter f$1;

    public /* synthetic */ _$$Lambda$LiveDataObservable$wtQDCfFf1Ih5nHx5_ovHcE5BosE(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter) {
        this.f$0 = liveDataObservable;
        this.f$1 = liveDataObserverAdapter;
    }

    @Override
    public final void run() {
        this.f$0.lambda$removeObserver$3$LiveDataObservable(this.f$1);
    }
}
