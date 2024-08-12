/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable
implements Disposable {
    final AtomicReference<Disposable> resource;

    public SerialDisposable() {
        this.resource = new AtomicReference();
    }

    public SerialDisposable(Disposable disposable) {
        this.resource = new AtomicReference<Disposable>(disposable);
    }

    public void dispose() {
        DisposableHelper.dispose(this.resource);
    }

    public Disposable get() {
        Disposable disposable;
        Disposable disposable2 = disposable = this.resource.get();
        if (disposable != DisposableHelper.DISPOSED) return disposable2;
        disposable2 = Disposables.disposed();
        return disposable2;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.resource.get());
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace(this.resource, (Disposable)disposable);
    }

    public boolean set(Disposable disposable) {
        return DisposableHelper.set(this.resource, (Disposable)disposable);
    }
}
