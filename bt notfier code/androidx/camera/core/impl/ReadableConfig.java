/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

public interface ReadableConfig
extends Config {
    public boolean containsOption(Config.Option<?> var1);

    public void findOptions(String var1, Config.OptionMatcher var2);

    public Config getConfig();

    public Config.OptionPriority getOptionPriority(Config.Option<?> var1);

    public Set<Config.OptionPriority> getPriorities(Config.Option<?> var1);

    public Set<Config.Option<?>> listOptions();

    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> var1);

    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> var1, ValueT var2);

    public <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> var1, Config.OptionPriority var2);
}
