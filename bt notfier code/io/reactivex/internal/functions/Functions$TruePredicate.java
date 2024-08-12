/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Predicate;

static final class Functions.TruePredicate
implements Predicate<Object> {
    Functions.TruePredicate() {
    }

    public boolean test(Object object) {
        return true;
    }
}
