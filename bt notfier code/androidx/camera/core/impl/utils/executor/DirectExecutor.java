/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

final class DirectExecutor
implements Executor {
    private static volatile DirectExecutor sDirectExecutor;

    DirectExecutor() {
    }

    static Executor getInstance() {
        if (sDirectExecutor != null) {
            return sDirectExecutor;
        }
        synchronized (DirectExecutor.class) {
            DirectExecutor directExecutor;
            if (sDirectExecutor != null) return sDirectExecutor;
            sDirectExecutor = directExecutor = new DirectExecutor();
            return sDirectExecutor;
        }
    }

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
