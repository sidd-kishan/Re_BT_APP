/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final class CallbackToFutureAdapter {
    private CallbackToFutureAdapter() {
    }

    public static <T> ListenableFuture<T> getFuture(Resolver<T> object) {
        SafeFuture safeFuture;
        Completer completer = new Completer();
        completer.future = safeFuture = new SafeFuture(completer);
        completer.tag = object.getClass();
        try {
            object = object.attachCompleter(completer);
            if (object == null) return safeFuture;
            completer.tag = object;
        }
        catch (Exception exception) {
            safeFuture.setException((Throwable)exception);
        }
        return safeFuture;
    }
}
