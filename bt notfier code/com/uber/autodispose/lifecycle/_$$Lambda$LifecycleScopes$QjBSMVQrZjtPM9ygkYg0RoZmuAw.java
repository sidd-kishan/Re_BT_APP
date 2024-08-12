/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.lifecycle.LifecycleScopes
 *  io.reactivex.functions.Predicate
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.lifecycle.LifecycleScopes;
import io.reactivex.functions.Predicate;

public final class _$$Lambda$LifecycleScopes$QjBSMVQrZjtPM9ygkYg0RoZmuAw
implements Predicate {
    private final Object f$0;

    public /* synthetic */ _$$Lambda$LifecycleScopes$QjBSMVQrZjtPM9ygkYg0RoZmuAw(Object object) {
        this.f$0 = object;
    }

    public final boolean test(Object object) {
        return LifecycleScopes.lambda$resolveScopeFromLifecycle$1((Object)this.f$0, (Object)object);
    }
}
