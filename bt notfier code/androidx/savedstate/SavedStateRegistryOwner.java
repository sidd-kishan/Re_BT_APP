/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.savedstate.SavedStateRegistry
 */
package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public interface SavedStateRegistryOwner
extends LifecycleOwner {
    public SavedStateRegistry getSavedStateRegistry();
}
