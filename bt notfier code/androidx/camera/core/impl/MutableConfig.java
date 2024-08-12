/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionPriority
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface MutableConfig
extends Config {
    public <ValueT> void insertOption(Config.Option<ValueT> var1, Config.OptionPriority var2, ValueT var3);

    public <ValueT> void insertOption(Config.Option<ValueT> var1, ValueT var2);

    public <ValueT> ValueT removeOption(Config.Option<ValueT> var1);
}
