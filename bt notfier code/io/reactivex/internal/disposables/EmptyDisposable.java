/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.fuseable.QueueDisposable
 */
package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueDisposable;

public final class EmptyDisposable
extends Enum<EmptyDisposable>
implements QueueDisposable<Object> {
    private static final EmptyDisposable[] $VALUES;
    public static final /* enum */ EmptyDisposable INSTANCE;
    public static final /* enum */ EmptyDisposable NEVER;

    static {
        EmptyDisposable emptyDisposable;
        INSTANCE = new EmptyDisposable();
        NEVER = emptyDisposable = new EmptyDisposable();
        $VALUES = new EmptyDisposable[]{INSTANCE, emptyDisposable};
    }

    public static void complete(CompletableObserver completableObserver) {
        completableObserver.onSubscribe((Disposable)INSTANCE);
        completableObserver.onComplete();
    }

    public static void complete(MaybeObserver<?> maybeObserver) {
        maybeObserver.onSubscribe((Disposable)INSTANCE);
        maybeObserver.onComplete();
    }

    public static void complete(Observer<?> observer) {
        observer.onSubscribe((Disposable)INSTANCE);
        observer.onComplete();
    }

    public static void error(Throwable throwable, CompletableObserver completableObserver) {
        completableObserver.onSubscribe((Disposable)INSTANCE);
        completableObserver.onError(throwable);
    }

    public static void error(Throwable throwable, MaybeObserver<?> maybeObserver) {
        maybeObserver.onSubscribe((Disposable)INSTANCE);
        maybeObserver.onError(throwable);
    }

    public static void error(Throwable throwable, Observer<?> observer) {
        observer.onSubscribe((Disposable)INSTANCE);
        observer.onError(throwable);
    }

    public static void error(Throwable throwable, SingleObserver<?> singleObserver) {
        singleObserver.onSubscribe((Disposable)INSTANCE);
        singleObserver.onError(throwable);
    }

    public static EmptyDisposable valueOf(String string) {
        return Enum.valueOf(EmptyDisposable.class, string);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[])$VALUES.clone();
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        boolean bl = this == INSTANCE;
        return bl;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object object, Object object2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    public int requestFusion(int n) {
        return n & 2;
    }
}
