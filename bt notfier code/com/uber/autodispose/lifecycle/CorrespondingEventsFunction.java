/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.OutsideScopeException
 *  io.reactivex.functions.Function
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import io.reactivex.functions.Function;

public interface CorrespondingEventsFunction<E>
extends Function<E, E> {
    public E apply(E var1) throws OutsideScopeException;
}
