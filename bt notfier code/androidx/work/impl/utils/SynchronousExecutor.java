/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import java.util.concurrent.Executor;

public class SynchronousExecutor
implements Executor {
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
