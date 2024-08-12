/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ReadableConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

public interface ThreadConfig
extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = Config.Option.create((String)"camerax.core.thread.backgroundExecutor", Executor.class);

    public Executor getBackgroundExecutor();

    public Executor getBackgroundExecutor(Executor var1);
}
