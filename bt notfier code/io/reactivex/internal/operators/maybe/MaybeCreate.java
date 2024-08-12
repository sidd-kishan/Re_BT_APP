/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeEmitter
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeOnSubscribe
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.maybe.MaybeCreate$Emitter
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.maybe.MaybeCreate;

public final class MaybeCreate<T>
extends Maybe<T> {
    final MaybeOnSubscribe<T> source;

    public MaybeCreate(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.source = maybeOnSubscribe;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Emitter emitter = new Emitter(maybeObserver);
        maybeObserver.onSubscribe((Disposable)emitter);
        try {
            this.source.subscribe((MaybeEmitter)emitter);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            emitter.onError(throwable);
        }
    }
}
