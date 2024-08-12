/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.AutoDisposeCompletable
 *  com.uber.autodispose.CompletableSubscribeProxy
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeCompletable;
import com.uber.autodispose.CompletableSubscribeProxy;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

class AutoDispose.1
implements CompletableSubscribeProxy {
    final AutoDispose.1 this$0;
    final Completable val$upstream;

    AutoDispose.1(AutoDispose.1 var1_1, Completable completable) {
        this.this$0 = var1_1;
        this.val$upstream = completable;
    }

    public Disposable subscribe() {
        return new AutoDisposeCompletable(this.val$upstream, this.this$0.val$scope).subscribe();
    }

    public Disposable subscribe(Action action) {
        return new AutoDisposeCompletable(this.val$upstream, this.this$0.val$scope).subscribe(action);
    }

    public Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        return new AutoDisposeCompletable(this.val$upstream, this.this$0.val$scope).subscribe(action, consumer);
    }

    public void subscribe(CompletableObserver completableObserver) {
        new AutoDisposeCompletable(this.val$upstream, this.this$0.val$scope).subscribe(completableObserver);
    }

    public <E extends CompletableObserver> E subscribeWith(E e) {
        return (E)new AutoDisposeCompletable(this.val$upstream, this.this$0.val$scope).subscribeWith(e);
    }

    public TestObserver<Void> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((CompletableObserver)testObserver);
        return testObserver;
    }

    public TestObserver<Void> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.cancel();
        }
        this.subscribe((CompletableObserver)testObserver);
        return testObserver;
    }
}
