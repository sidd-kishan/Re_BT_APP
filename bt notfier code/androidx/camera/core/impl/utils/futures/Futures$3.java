/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class Futures.3
implements FutureCallback<I> {
    final CallbackToFutureAdapter.Completer val$completer;
    final Function val$function;

    Futures.3(CallbackToFutureAdapter.Completer completer, Function function) {
        this.val$completer = completer;
        this.val$function = function;
    }

    public void onFailure(Throwable throwable) {
        this.val$completer.setException(throwable);
    }

    public void onSuccess(I i) {
        try {
            this.val$completer.set(this.val$function.apply(i));
        }
        catch (Throwable throwable) {
            this.val$completer.setException(throwable);
        }
    }
}
