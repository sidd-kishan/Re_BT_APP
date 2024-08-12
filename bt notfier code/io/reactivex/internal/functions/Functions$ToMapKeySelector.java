/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import java.util.Map;

static final class Functions.ToMapKeySelector<K, T>
implements BiConsumer<Map<K, T>, T> {
    private final Function<? super T, ? extends K> keySelector;

    Functions.ToMapKeySelector(Function<? super T, ? extends K> function) {
        this.keySelector = function;
    }

    public void accept(Map<K, T> map, T t) throws Exception {
        map.put(this.keySelector.apply(t), t);
    }
}
