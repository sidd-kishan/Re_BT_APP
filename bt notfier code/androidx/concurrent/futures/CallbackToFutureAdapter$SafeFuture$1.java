/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class CallbackToFutureAdapter.SafeFuture.1
extends AbstractResolvableFuture<T> {
    final CallbackToFutureAdapter.SafeFuture this$0;

    CallbackToFutureAdapter.SafeFuture.1(CallbackToFutureAdapter.SafeFuture safeFuture) {
        this.this$0 = safeFuture;
    }

    protected String pendingToString() {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer)this.this$0.completerWeakReference.get();
        if (completer == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=[");
        stringBuilder.append(completer.tag);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
