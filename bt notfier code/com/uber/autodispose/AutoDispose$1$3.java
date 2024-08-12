/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.AutoDisposeMaybe
 *  com.uber.autodispose.MaybeSubscribeProxy
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeMaybe;
import com.uber.autodispose.MaybeSubscribeProxy;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

class AutoDispose.3
implements MaybeSubscribeProxy<T> {
    final AutoDispose.1 this$0;
    final Maybe val$upstream;

    AutoDispose.3(AutoDispose.1 var1_1, Maybe maybe) {
        this.this$0 = var1_1;
        this.val$upstream = maybe;
    }

    public Disposable subscribe() {
        return new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribe();
    }

    public Disposable subscribe(Consumer<? super T> consumer) {
        return new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2, action);
    }

    public void subscribe(MaybeObserver<? super T> maybeObserver) {
        new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribe(maybeObserver);
    }

    public <E extends MaybeObserver<? super T>> E subscribeWith(E e) {
        return (E)new AutoDisposeMaybe((MaybeSource)this.val$upstream, this.this$0.val$scope).subscribeWith(e);
    }

    public TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((MaybeObserver)testObserver);
        return testObserver;
    }

    public TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.cancel();
        }
        this.subscribe((MaybeObserver)testObserver);
        return testObserver;
    }
}
