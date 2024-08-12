/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.ReadableConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.Set;

public final class ReadableConfig$_CC {
    public static boolean $default$containsOption(ReadableConfig readableConfig, Config.Option<?> option) {
        return readableConfig.getConfig().containsOption(option);
    }

    public static void $default$findOptions(ReadableConfig readableConfig, String string, Config.OptionMatcher optionMatcher) {
        readableConfig.getConfig().findOptions(string, optionMatcher);
    }

    public static Config.OptionPriority $default$getOptionPriority(ReadableConfig readableConfig, Config.Option<?> option) {
        return readableConfig.getConfig().getOptionPriority(option);
    }

    public static Set<Config.OptionPriority> $default$getPriorities(ReadableConfig readableConfig, Config.Option<?> option) {
        return readableConfig.getConfig().getPriorities(option);
    }

    public static Set<Config.Option<?>> $default$listOptions(ReadableConfig readableConfig) {
        return readableConfig.getConfig().listOptions();
    }

    public static <ValueT> ValueT $default$retrieveOption(ReadableConfig readableConfig, Config.Option<ValueT> option) {
        return (ValueT)readableConfig.getConfig().retrieveOption(option);
    }

    public static <ValueT> ValueT $default$retrieveOption(ReadableConfig readableConfig, Config.Option<ValueT> option, ValueT ValueT) {
        return (ValueT)readableConfig.getConfig().retrieveOption(option, ValueT);
    }

    public static <ValueT> ValueT $default$retrieveOptionWithPriority(ReadableConfig readableConfig, Config.Option<ValueT> option, Config.OptionPriority optionPriority) {
        return (ValueT)readableConfig.getConfig().retrieveOptionWithPriority(option, optionPriority);
    }
}
