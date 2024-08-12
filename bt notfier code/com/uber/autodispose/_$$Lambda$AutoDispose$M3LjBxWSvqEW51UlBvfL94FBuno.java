/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose
 *  com.uber.autodispose.ScopeProvider
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.ScopeProvider;
import java.util.concurrent.Callable;

public final class _$$Lambda$AutoDispose$M3LjBxWSvqEW51UlBvfL94FBuno
implements Callable {
    private final ScopeProvider f$0;

    public /* synthetic */ _$$Lambda$AutoDispose$M3LjBxWSvqEW51UlBvfL94FBuno(ScopeProvider scopeProvider) {
        this.f$0 = scopeProvider;
    }

    public final Object call() {
        return AutoDispose.lambda$autoDisposable$0((ScopeProvider)this.f$0);
    }
}
