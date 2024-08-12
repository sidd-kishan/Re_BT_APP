/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.ScopeProvider
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 */
package com.uber.autodispose;

import com.uber.autodispose.ScopeProvider;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;

public final class _$$Lambda$86PAqS_ZSNdQP5azjv_won8FLFg
implements ScopeProvider {
    public static final _$$Lambda$86PAqS_ZSNdQP5azjv_won8FLFg INSTANCE = new _$$Lambda$86PAqS_ZSNdQP5azjv_won8FLFg();

    private /* synthetic */ _$$Lambda$86PAqS_ZSNdQP5azjv_won8FLFg() {
    }

    public final CompletableSource requestScope() {
        return (CompletableSource)Completable.never();
    }
}
