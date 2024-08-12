/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.impl.utils.executor.DirectExecutor
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService
 *  androidx.camera.core.impl.utils.executor.HighPriorityExecutor
 *  androidx.camera.core.impl.utils.executor.IoExecutor
 *  androidx.camera.core.impl.utils.executor.MainThreadExecutor
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.DirectExecutor;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import androidx.camera.core.impl.utils.executor.IoExecutor;
import androidx.camera.core.impl.utils.executor.MainThreadExecutor;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class CameraXExecutors {
    private CameraXExecutors() {
    }

    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    public static boolean isSequentialExecutor(Executor executor) {
        return executor instanceof SequentialExecutor;
    }

    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }

    public static ScheduledExecutorService newHandlerExecutor(Handler handler) {
        return new HandlerScheduledExecutorService(handler);
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
