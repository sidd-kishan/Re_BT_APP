/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.internal.fuseable.HasUpstreamCompletableSource
 *  io.reactivex.internal.operators.maybe.MaybeFromCompletable$FromCompletableObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.fuseable.HasUpstreamCompletableSource;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;

public final class MaybeFromCompletable<T>
extends Maybe<T>
implements HasUpstreamCompletableSource {
    final CompletableSource source;

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    public CompletableSource source() {
        return this.source;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((CompletableObserver)new FromCompletableObserver(maybeObserver));
    }
}
