/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.AutoDisposeObservable
 *  com.uber.autodispose.ObservableSubscribeProxy
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeObservable;
import com.uber.autodispose.ObservableSubscribeProxy;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

class AutoDispose.4
implements ObservableSubscribeProxy<T> {
    final AutoDispose.1 this$0;
    final Observable val$upstream;

    AutoDispose.4(AutoDispose.1 var1_1, Observable observable) {
        this.this$0 = var1_1;
        this.val$upstream = observable;
    }

    public Disposable subscribe() {
        return new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe();
    }

    public Disposable subscribe(Consumer<? super T> consumer) {
        return new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2, action);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        return new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2, action, consumer3);
    }

    public void subscribe(Observer<? super T> observer) {
        new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribe(observer);
    }

    public <E extends Observer<? super T>> E subscribeWith(E e) {
        return (E)new AutoDisposeObservable((ObservableSource)this.val$upstream, this.this$0.val$scope).subscribeWith(e);
    }

    public TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((Observer)testObserver);
        return testObserver;
    }

    public TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.dispose();
        }
        this.subscribe((Observer)testObserver);
        return testObserver;
    }
}
