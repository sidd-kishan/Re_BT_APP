/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.MutableConfig
 */
package androidx.camera.core;

import androidx.camera.core.impl.MutableConfig;

public interface ExtendableBuilder<T> {
    public T build();

    public MutableConfig getMutableConfig();
}
