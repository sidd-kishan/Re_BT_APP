/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableEmitter
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableOnSubscribe
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.completable.CompletableCreate$Emitter
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.completable.CompletableCreate;

public final class CompletableCreate
extends Completable {
    final CompletableOnSubscribe source;

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.source = completableOnSubscribe;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        Emitter emitter = new Emitter(completableObserver);
        completableObserver.onSubscribe((Disposable)emitter);
        try {
            this.source.subscribe((CompletableEmitter)emitter);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            emitter.onError(throwable);
        }
    }
}
