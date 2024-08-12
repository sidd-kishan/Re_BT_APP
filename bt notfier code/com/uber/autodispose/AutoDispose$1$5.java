/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.AutoDisposeSingle
 *  com.uber.autodispose.SingleSubscribeProxy
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeSingle;
import com.uber.autodispose.SingleSubscribeProxy;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

class AutoDispose.5
implements SingleSubscribeProxy<T> {
    final AutoDispose.1 this$0;
    final Single val$upstream;

    AutoDispose.5(AutoDispose.1 var1_1, Single single) {
        this.this$0 = var1_1;
        this.val$upstream = single;
    }

    public Disposable subscribe() {
        return new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribe();
    }

    public Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        return new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribe(biConsumer);
    }

    public Disposable subscribe(Consumer<? super T> consumer) {
        return new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2);
    }

    public void subscribe(SingleObserver<? super T> singleObserver) {
        new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribe(singleObserver);
    }

    public <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        return (E)new AutoDisposeSingle((SingleSource)this.val$upstream, this.this$0.val$scope).subscribeWith(e);
    }

    public TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((SingleObserver)testObserver);
        return testObserver;
    }

    public TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.dispose();
        }
        this.subscribe((SingleObserver)testObserver);
        return testObserver;
    }
}
