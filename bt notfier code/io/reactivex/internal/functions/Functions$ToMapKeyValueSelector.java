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

static final class Functions.ToMapKeyValueSelector<K, V, T>
implements BiConsumer<Map<K, V>, T> {
    private final Function<? super T, ? extends K> keySelector;
    private final Function<? super T, ? extends V> valueSelector;

    Functions.ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
        this.valueSelector = function;
        this.keySelector = function2;
    }

    public void accept(Map<K, V> map, T t) throws Exception {
        map.put(this.keySelector.apply(t), this.valueSelector.apply(t));
    }
}
