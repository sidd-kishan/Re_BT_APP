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
import java.util.Comparator;

public final class _$$Lambda$LifecycleScopes$G1LKlBOCt1oQBQl4AgpxLOoK0Lo
implements Predicate {
    private final Comparator f$0;
    private final Object f$1;

    public /* synthetic */ _$$Lambda$LifecycleScopes$G1LKlBOCt1oQBQl4AgpxLOoK0Lo(Comparator comparator, Object object) {
        this.f$0 = comparator;
        this.f$1 = object;
    }

    public final boolean test(Object object) {
        return LifecycleScopes.lambda$resolveScopeFromLifecycle$0((Comparator)this.f$0, (Object)this.f$1, (Object)object);
    }
}
