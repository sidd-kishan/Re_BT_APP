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

public interface TargetConfig<T>
extends ReadableConfig {
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS;
    public static final Config.Option<String> OPTION_TARGET_NAME;

    static {
        OPTION_TARGET_NAME = Config.Option.create((String)"camerax.core.target.name", String.class);
        OPTION_TARGET_CLASS = Config.Option.create((String)"camerax.core.target.class", Class.class);
    }

    public Class<T> getTargetClass();

    public Class<T> getTargetClass(Class<T> var1);

    public String getTargetName();

    public String getTargetName(String var1);
}
