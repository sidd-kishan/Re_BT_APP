/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface ConfigProvider<C extends Config> {
    public C getConfig();
}
