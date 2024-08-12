/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

public interface Config {
    public boolean containsOption(Option<?> var1);

    public void findOptions(String var1, OptionMatcher var2);

    public OptionPriority getOptionPriority(Option<?> var1);

    public Set<OptionPriority> getPriorities(Option<?> var1);

    public Set<Option<?>> listOptions();

    public <ValueT> ValueT retrieveOption(Option<ValueT> var1);

    public <ValueT> ValueT retrieveOption(Option<ValueT> var1, ValueT var2);

    public <ValueT> ValueT retrieveOptionWithPriority(Option<ValueT> var1, OptionPriority var2);
}
