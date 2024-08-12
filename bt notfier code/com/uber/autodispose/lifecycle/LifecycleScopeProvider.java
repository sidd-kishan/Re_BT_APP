/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.ScopeProvider
 *  com.uber.autodispose.lifecycle.CorrespondingEventsFunction
 *  io.reactivex.Observable
 *  io.reactivex.annotations.CheckReturnValue
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;

public interface LifecycleScopeProvider<E>
extends ScopeProvider {
    @CheckReturnValue
    public CorrespondingEventsFunction<E> correspondingEvents();

    @CheckReturnValue
    public Observable<E> lifecycle();

    public E peekLifecycle();
}
