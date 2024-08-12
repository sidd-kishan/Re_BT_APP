/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  retrofit2.Call
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.disposables.Disposable;
import retrofit2.Call;

private static final class CallExecuteObservable.CallDisposable
implements Disposable {
    private final Call<?> call;
    private volatile boolean disposed;

    CallExecuteObservable.CallDisposable(Call<?> call) {
        this.call = call;
    }

    public void dispose() {
        this.disposed = true;
        this.call.cancel();
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}
