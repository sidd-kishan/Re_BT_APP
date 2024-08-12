/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposeConverter
 *  com.uber.autodispose.AutoDisposePlugins
 *  com.uber.autodispose.AutoDisposeUtil
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.ScopeProvider
 *  com.uber.autodispose._$$Lambda$AutoDispose$M3LjBxWSvqEW51UlBvfL94FBuno
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.functions.Consumer
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.AutoDisposePlugins;
import com.uber.autodispose.AutoDisposeUtil;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose._$;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;

public final class AutoDispose {
    private AutoDispose() {
        throw new AssertionError((Object)"No instances");
    }

    public static <T> AutoDisposeConverter<T> autoDisposable(ScopeProvider scopeProvider) {
        AutoDisposeUtil.checkNotNull((Object)scopeProvider, (String)"provider == null");
        return AutoDispose.autoDisposable((CompletableSource)Completable.defer((Callable)new _$.Lambda.AutoDispose.M3LjBxWSvqEW51UlBvfL94FBuno(scopeProvider)));
    }

    public static <T> AutoDisposeConverter<T> autoDisposable(CompletableSource completableSource) {
        AutoDisposeUtil.checkNotNull((Object)completableSource, (String)"scope == null");
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ CompletableSource lambda$autoDisposable$0(ScopeProvider scopeProvider) throws Exception {
        try {
            scopeProvider = scopeProvider.requestScope();
            return scopeProvider;
        }
        catch (OutsideScopeException outsideScopeException) {
            Consumer consumer = AutoDisposePlugins.getOutsideScopeHandler();
            if (consumer == null) return Completable.error((Throwable)outsideScopeException);
            consumer.accept((Object)outsideScopeException);
            return Completable.complete();
        }
    }
}
