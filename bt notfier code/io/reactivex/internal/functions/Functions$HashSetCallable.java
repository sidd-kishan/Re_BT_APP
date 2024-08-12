/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.functions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

static final class Functions.HashSetCallable
extends Enum<Functions.HashSetCallable>
implements Callable<Set<Object>> {
    private static final Functions.HashSetCallable[] $VALUES;
    public static final /* enum */ Functions.HashSetCallable INSTANCE;

    static {
        Functions.HashSetCallable hashSetCallable;
        INSTANCE = hashSetCallable = new Functions.HashSetCallable();
        $VALUES = new Functions.HashSetCallable[]{hashSetCallable};
    }

    public static Functions.HashSetCallable valueOf(String string) {
        return Enum.valueOf(Functions.HashSetCallable.class, string);
    }

    public static Functions.HashSetCallable[] values() {
        return (Functions.HashSetCallable[])$VALUES.clone();
    }

    @Override
    public Set<Object> call() throws Exception {
        return new HashSet<Object>();
    }
}
