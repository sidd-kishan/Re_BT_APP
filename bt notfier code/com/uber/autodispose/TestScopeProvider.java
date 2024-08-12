/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.ScopeProvider
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.subjects.CompletableSubject
 */
package com.uber.autodispose;

import com.uber.autodispose.ScopeProvider;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.subjects.CompletableSubject;

public final class TestScopeProvider
implements ScopeProvider {
    private final CompletableSubject innerScope;

    private TestScopeProvider(Completable completable) {
        CompletableSubject completableSubject;
        this.innerScope = completableSubject = CompletableSubject.create();
        completable.subscribe((CompletableObserver)completableSubject);
    }

    public static TestScopeProvider create() {
        return TestScopeProvider.create((Completable)CompletableSubject.create());
    }

    public static TestScopeProvider create(Completable completable) {
        return new TestScopeProvider(completable);
    }

    public void emit() {
        this.innerScope.onComplete();
    }

    public CompletableSource requestScope() {
        return this.innerScope;
    }
}
