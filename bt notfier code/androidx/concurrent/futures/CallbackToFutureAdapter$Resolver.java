/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public static interface CallbackToFutureAdapter.Resolver<T> {
    public Object attachCompleter(CallbackToFutureAdapter.Completer<T> var1) throws Exception;
}
