/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter
 *  androidx.camera.core.impl.LiveDataObservable$Result
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final class _$$Lambda$LiveDataObservable$LiveDataObserverAdapter$BwSPpp5UumdKUg6VO_EGS78cZ_Y
implements Runnable {
    private final LiveDataObservable.LiveDataObserverAdapter f$0;
    private final LiveDataObservable.Result f$1;

    public /* synthetic */ _$$Lambda$LiveDataObservable$LiveDataObserverAdapter$BwSPpp5UumdKUg6VO_EGS78cZ_Y(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.f$0 = liveDataObserverAdapter;
        this.f$1 = result;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onChanged$0$LiveDataObservable$LiveDataObserverAdapter(this.f$1);
    }
}
