/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.ArchTaskExecutor
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ArchTaskExecutor.1
implements Executor {
    ArchTaskExecutor.1() {
    }

    @Override
    public void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().postToMainThread(runnable);
    }
}
