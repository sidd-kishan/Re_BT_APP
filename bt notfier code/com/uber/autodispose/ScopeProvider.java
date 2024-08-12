/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose._$$Lambda$86PAqS_ZSNdQP5azjv_won8FLFg
 *  io.reactivex.CompletableSource
 *  io.reactivex.annotations.CheckReturnValue
 */
package com.uber.autodispose;

import com.uber.autodispose._$;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.CheckReturnValue;

public interface ScopeProvider {
    public static final ScopeProvider UNBOUND = _$.Lambda.86PAqS_ZSNdQP5azjv_won8FLFg.INSTANCE;

    @CheckReturnValue
    public CompletableSource requestScope() throws Exception;
}
