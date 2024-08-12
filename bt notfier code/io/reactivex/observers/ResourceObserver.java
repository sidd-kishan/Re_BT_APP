/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.ListCompositeDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.EndConsumerHelper
 */
package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceObserver<T>
implements Observer<T>,
Disposable {
    private final ListCompositeDisposable resources;
    private final AtomicReference<Disposable> upstream = new AtomicReference();

    public ResourceObserver() {
        this.resources = new ListCompositeDisposable();
    }

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"resource is null");
        this.resources.add(disposable);
    }

    public final void dispose() {
        if (!DisposableHelper.dispose(this.upstream)) return;
        this.resources.dispose();
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    protected void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (!EndConsumerHelper.setOnce(this.upstream, (Disposable)disposable, this.getClass())) return;
        this.onStart();
    }
}
