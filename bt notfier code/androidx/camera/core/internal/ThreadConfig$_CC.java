/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.ThreadConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.ThreadConfig;
import java.util.concurrent.Executor;

public final class ThreadConfig$_CC {
    public static Executor $default$getBackgroundExecutor(ThreadConfig threadConfig) {
        return (Executor)threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public static Executor $default$getBackgroundExecutor(ThreadConfig threadConfig, Executor executor) {
        return (Executor)threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, (Object)executor);
    }
}
