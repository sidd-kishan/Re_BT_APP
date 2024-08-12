/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
    AtomicReference<Object> mInternalScopeRef = new AtomicReference();

    public abstract void addObserver(LifecycleObserver var1);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver var1);
}
