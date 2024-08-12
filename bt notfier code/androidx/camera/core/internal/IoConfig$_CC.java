/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.IoConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.IoConfig;
import java.util.concurrent.Executor;

public final class IoConfig$_CC {
    public static Executor $default$getIoExecutor(IoConfig ioConfig) {
        return (Executor)ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    public static Executor $default$getIoExecutor(IoConfig ioConfig, Executor executor) {
        return (Executor)ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, (Object)executor);
    }
}
