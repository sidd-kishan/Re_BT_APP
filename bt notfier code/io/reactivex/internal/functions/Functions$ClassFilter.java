/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Predicate;

static final class Functions.ClassFilter<T, U>
implements Predicate<T> {
    final Class<U> clazz;

    Functions.ClassFilter(Class<U> clazz) {
        this.clazz = clazz;
    }

    public boolean test(T t) throws Exception {
        return this.clazz.isInstance(t);
    }
}
