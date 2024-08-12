/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;

static final class Functions.EqualsPredicate<T>
implements Predicate<T> {
    final T value;

    Functions.EqualsPredicate(T t) {
        this.value = t;
    }

    public boolean test(T t) throws Exception {
        return ObjectHelper.equals(t, this.value);
    }
}
