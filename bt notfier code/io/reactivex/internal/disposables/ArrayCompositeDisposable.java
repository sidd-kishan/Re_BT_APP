/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable
extends AtomicReferenceArray<Disposable>
implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int n) {
        super(n);
    }

    public void dispose() {
        int n = 0;
        if (this.get(0) == DisposableHelper.DISPOSED) return;
        int n2 = this.length();
        while (n < n2) {
            Disposable disposable;
            if ((Disposable)this.get(n) != DisposableHelper.DISPOSED && (disposable = (Disposable)this.getAndSet(n, DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED && disposable != null) {
                disposable.dispose();
            }
            ++n;
        }
    }

    public boolean isDisposed() {
        boolean bl = false;
        if (this.get(0) != DisposableHelper.DISPOSED) return bl;
        bl = true;
        return bl;
    }

    public Disposable replaceResource(int n, Disposable disposable) {
        Disposable disposable2;
        do {
            if ((disposable2 = (Disposable)this.get(n)) != DisposableHelper.DISPOSED) continue;
            disposable.dispose();
            return null;
        } while (!this.compareAndSet(n, disposable2, disposable));
        return disposable2;
    }

    public boolean setResource(int n, Disposable disposable) {
        Disposable disposable2;
        do {
            if ((disposable2 = (Disposable)this.get(n)) != DisposableHelper.DISPOSED) continue;
            disposable.dispose();
            return false;
        } while (!this.compareAndSet(n, disposable2, disposable));
        if (disposable2 == null) return true;
        disposable2.dispose();
        return true;
    }
}
