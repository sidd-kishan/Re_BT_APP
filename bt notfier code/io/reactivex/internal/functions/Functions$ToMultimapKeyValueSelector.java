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
import java.util.Collection;
import java.util.Map;

static final class Functions.ToMultimapKeyValueSelector<K, V, T>
implements BiConsumer<Map<K, Collection<V>>, T> {
    private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
    private final Function<? super T, ? extends K> keySelector;
    private final Function<? super T, ? extends V> valueSelector;

    Functions.ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
        this.collectionFactory = function;
        this.valueSelector = function2;
        this.keySelector = function3;
    }

    public void accept(Map<K, Collection<V>> map, T t) throws Exception {
        Collection collection;
        Object object = this.keySelector.apply(t);
        Collection collection2 = collection = map.get(object);
        if (collection == null) {
            collection2 = (Collection)this.collectionFactory.apply(object);
            map.put(object, collection2);
        }
        collection2.add(this.valueSelector.apply(t));
    }
}
