/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

static final class Functions.ListSorter<T>
implements Function<List<T>, List<T>> {
    final Comparator<? super T> comparator;

    Functions.ListSorter(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public List<T> apply(List<T> list) {
        Collections.sort(list, this.comparator);
        return list;
    }
}
