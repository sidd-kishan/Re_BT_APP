/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.operators.single;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

static final class SingleInternalHelper.NoSuchElementCallable
extends Enum<SingleInternalHelper.NoSuchElementCallable>
implements Callable<NoSuchElementException> {
    private static final SingleInternalHelper.NoSuchElementCallable[] $VALUES;
    public static final /* enum */ SingleInternalHelper.NoSuchElementCallable INSTANCE;

    static {
        SingleInternalHelper.NoSuchElementCallable noSuchElementCallable;
        INSTANCE = noSuchElementCallable = new SingleInternalHelper.NoSuchElementCallable();
        $VALUES = new SingleInternalHelper.NoSuchElementCallable[]{noSuchElementCallable};
    }

    public static SingleInternalHelper.NoSuchElementCallable valueOf(String string) {
        return Enum.valueOf(SingleInternalHelper.NoSuchElementCallable.class, string);
    }

    public static SingleInternalHelper.NoSuchElementCallable[] values() {
        return (SingleInternalHelper.NoSuchElementCallable[])$VALUES.clone();
    }

    @Override
    public NoSuchElementException call() throws Exception {
        return new NoSuchElementException();
    }
}
