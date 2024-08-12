/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 */
package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

public final class ListAddBiConsumer
extends Enum<ListAddBiConsumer>
implements BiFunction<List, Object, List> {
    private static final ListAddBiConsumer[] $VALUES;
    public static final /* enum */ ListAddBiConsumer INSTANCE;

    static {
        ListAddBiConsumer listAddBiConsumer;
        INSTANCE = listAddBiConsumer = new ListAddBiConsumer();
        $VALUES = new ListAddBiConsumer[]{listAddBiConsumer};
    }

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String string) {
        return Enum.valueOf(ListAddBiConsumer.class, string);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[])$VALUES.clone();
    }

    public List apply(List list, Object object) throws Exception {
        list.add(object);
        return list;
    }
}
