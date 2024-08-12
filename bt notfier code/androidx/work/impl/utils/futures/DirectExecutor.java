/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

final class DirectExecutor
extends Enum<DirectExecutor>
implements Executor {
    private static final DirectExecutor[] $VALUES;
    public static final /* enum */ DirectExecutor INSTANCE;

    static {
        DirectExecutor directExecutor;
        INSTANCE = directExecutor = new DirectExecutor();
        $VALUES = new DirectExecutor[]{directExecutor};
    }

    public static DirectExecutor valueOf(String string) {
        return Enum.valueOf(DirectExecutor.class, string);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[])$VALUES.clone();
    }

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
