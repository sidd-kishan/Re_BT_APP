/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleEmitter
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleOnSubscribe
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleCreate$Emitter
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleCreate;

public final class SingleCreate<T>
extends Single<T> {
    final SingleOnSubscribe<T> source;

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.source = singleOnSubscribe;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.onSubscribe((Disposable)emitter);
        try {
            this.source.subscribe((SingleEmitter)emitter);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            emitter.onError(throwable);
        }
    }
}
