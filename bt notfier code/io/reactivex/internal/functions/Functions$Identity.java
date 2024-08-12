/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;

static final class Functions.Identity
implements Function<Object, Object> {
    Functions.Identity() {
    }

    public Object apply(Object object) {
        return object;
    }

    public String toString() {
        return "IdentityFunction";
    }
}
