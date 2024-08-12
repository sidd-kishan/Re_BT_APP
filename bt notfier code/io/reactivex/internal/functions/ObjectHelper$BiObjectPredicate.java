/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.functions.ObjectHelper;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ObjectHelper.BiObjectPredicate
implements BiPredicate<Object, Object> {
    ObjectHelper.BiObjectPredicate() {
    }

    public boolean test(Object object, Object object2) {
        return ObjectHelper.equals((Object)object, (Object)object2);
    }
}
