/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.functions.Predicate
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Predicate;

static final class Functions.BooleanSupplierPredicateReverse<T>
implements Predicate<T> {
    final BooleanSupplier supplier;

    Functions.BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
        this.supplier = booleanSupplier;
    }

    public boolean test(T t) throws Exception {
        return this.supplier.getAsBoolean() ^ true;
    }
}
