/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SorterFunction<T>
implements Function<List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public SorterFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.comparator);
        return list;
    }
}
