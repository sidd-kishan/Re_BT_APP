/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ArrayListSupplier
extends Enum<ArrayListSupplier>
implements Callable<List<Object>>,
Function<Object, List<Object>> {
    private static final ArrayListSupplier[] $VALUES;
    public static final /* enum */ ArrayListSupplier INSTANCE;

    static {
        ArrayListSupplier arrayListSupplier;
        INSTANCE = arrayListSupplier = new ArrayListSupplier();
        $VALUES = new ArrayListSupplier[]{arrayListSupplier};
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> Function<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String string) {
        return Enum.valueOf(ArrayListSupplier.class, string);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[])$VALUES.clone();
    }

    public List<Object> apply(Object object) throws Exception {
        return new ArrayList<Object>();
    }

    @Override
    public List<Object> call() throws Exception {
        return new ArrayList<Object>();
    }
}
