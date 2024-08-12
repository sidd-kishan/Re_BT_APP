/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

@Deprecated
public interface LifecycleRegistryOwner
extends LifecycleOwner {
    public LifecycleRegistry getLifecycle();
}
