/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.functions;

import java.util.Comparator;

static final class Functions.NaturalObjectComparator
implements Comparator<Object> {
    Functions.NaturalObjectComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}
