/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.lifecycle.CorrespondingEventsFunction
 *  com.uber.autodispose.lifecycle.LifecycleEndedException
 *  com.uber.autodispose.lifecycle.LifecycleScopeProvider
 *  com.uber.autodispose.lifecycle.LifecycleScopes
 *  com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$1
 *  com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle
 *  com.uber.autodispose.lifecycle._$$Lambda$TestLifecycleScopeProvider$9MC6qI4yUDos4hauJK5OZlRThik
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.subjects.BehaviorSubject
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;
import com.uber.autodispose.lifecycle.LifecycleScopes;
import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider;
import com.uber.autodispose.lifecycle._$;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public final class TestLifecycleScopeProvider
implements LifecycleScopeProvider<TestLifecycle> {
    private final BehaviorSubject<TestLifecycle> lifecycleSubject;

    private TestLifecycleScopeProvider(TestLifecycle testLifecycle) {
        this.lifecycleSubject = testLifecycle == null ? BehaviorSubject.create() : BehaviorSubject.createDefault((Object)testLifecycle);
    }

    public static TestLifecycleScopeProvider create() {
        return new TestLifecycleScopeProvider(null);
    }

    public static TestLifecycleScopeProvider createInitial(TestLifecycle testLifecycle) {
        return new TestLifecycleScopeProvider(testLifecycle);
    }

    static /* synthetic */ TestLifecycle lambda$correspondingEvents$0(TestLifecycle testLifecycle) throws OutsideScopeException {
        int n = 1.$SwitchMap$com$uber$autodispose$lifecycle$TestLifecycleScopeProvider$TestLifecycle[testLifecycle.ordinal()];
        if (n == 1) return TestLifecycle.STOPPED;
        if (n == 2) throw new LifecycleEndedException();
        throw new IllegalStateException("Unknown lifecycle event.");
    }

    public CorrespondingEventsFunction<TestLifecycle> correspondingEvents() {
        return _$.Lambda.TestLifecycleScopeProvider.9MC6qI4yUDos4hauJK5OZlRThik.INSTANCE;
    }

    public Observable<TestLifecycle> lifecycle() {
        return this.lifecycleSubject.hide();
    }

    public TestLifecycle peekLifecycle() {
        return (TestLifecycle)this.lifecycleSubject.getValue();
    }

    public CompletableSource requestScope() {
        return LifecycleScopes.resolveScopeFromLifecycle((LifecycleScopeProvider)this);
    }

    public void start() {
        this.lifecycleSubject.onNext((Object)TestLifecycle.STARTED);
    }

    public void stop() {
        if (this.lifecycleSubject.getValue() != TestLifecycle.STARTED) throw new IllegalStateException("Attempting to stop lifecycle before starting it.");
        this.lifecycleSubject.onNext((Object)TestLifecycle.STOPPED);
    }
}
