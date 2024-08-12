/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.ConstantObservable
 *  androidx.camera.core.impl.Observable$Observer
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;

public final class _$$Lambda$ConstantObservable$kXgoMj_SEvwvi5lWtNwahKNa7kU
implements Runnable {
    private final ConstantObservable f$0;
    private final Observable.Observer f$1;

    public /* synthetic */ _$$Lambda$ConstantObservable$kXgoMj_SEvwvi5lWtNwahKNa7kU(ConstantObservable constantObservable, Observable.Observer observer) {
        this.f$0 = constantObservable;
        this.f$1 = observer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$addObserver$0$ConstantObservable(this.f$1);
    }
}
