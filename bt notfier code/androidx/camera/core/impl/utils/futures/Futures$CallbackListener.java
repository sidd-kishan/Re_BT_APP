/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/*
 * Exception performing whole class analysis ignored.
 */
private static final class Futures.CallbackListener<V>
implements Runnable {
    final FutureCallback<? super V> mCallback;
    final Future<V> mFuture;

    Futures.CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
        this.mFuture = future;
        this.mCallback = futureCallback;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void run() {
        void var1_4;
        block4: {
            Object object;
            try {
                object = Futures.getDone(this.mFuture);
            }
            catch (Error error) {
                break block4;
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
                break block4;
            }
            catch (ExecutionException executionException) {
                this.mCallback.onFailure(executionException.getCause());
                return;
            }
            this.mCallback.onSuccess(object);
            return;
        }
        this.mCallback.onFailure((Throwable)var1_4);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(",");
        stringBuilder.append(this.mCallback);
        return stringBuilder.toString();
    }
}
