/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.fuseable.FuseToMaybe
 *  io.reactivex.internal.operators.maybe.MaybeIgnoreElement
 *  io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable$IgnoreMaybeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElement;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIgnoreElementCompletable<T>
extends Completable
implements FuseToMaybe<T> {
    final MaybeSource<T> source;

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly((Maybe)new MaybeIgnoreElement(this.source));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((MaybeObserver)new IgnoreMaybeObserver(completableObserver));
    }
}
