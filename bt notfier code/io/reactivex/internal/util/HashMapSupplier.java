/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class HashMapSupplier
extends Enum<HashMapSupplier>
implements Callable<Map<Object, Object>> {
    private static final HashMapSupplier[] $VALUES;
    public static final /* enum */ HashMapSupplier INSTANCE;

    static {
        HashMapSupplier hashMapSupplier;
        INSTANCE = hashMapSupplier = new HashMapSupplier();
        $VALUES = new HashMapSupplier[]{hashMapSupplier};
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String string) {
        return Enum.valueOf(HashMapSupplier.class, string);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[])$VALUES.clone();
    }

    @Override
    public Map<Object, Object> call() throws Exception {
        return new HashMap<Object, Object>();
    }
}
