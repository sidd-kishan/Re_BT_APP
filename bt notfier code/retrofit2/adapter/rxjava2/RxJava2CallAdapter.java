/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureStrategy
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.plugins.RxJavaPlugins
 *  retrofit2.Call
 *  retrofit2.CallAdapter
 *  retrofit2.adapter.rxjava2.BodyObservable
 *  retrofit2.adapter.rxjava2.CallEnqueueObservable
 *  retrofit2.adapter.rxjava2.CallExecuteObservable
 *  retrofit2.adapter.rxjava2.ResultObservable
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava2.BodyObservable;
import retrofit2.adapter.rxjava2.CallEnqueueObservable;
import retrofit2.adapter.rxjava2.CallExecuteObservable;
import retrofit2.adapter.rxjava2.ResultObservable;

final class RxJava2CallAdapter<R>
implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    @Nullable
    private final Scheduler scheduler;

    RxJava2CallAdapter(Type type, @Nullable Scheduler scheduler, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = bl;
        this.isResult = bl2;
        this.isBody = bl3;
        this.isFlowable = bl4;
        this.isSingle = bl5;
        this.isMaybe = bl6;
        this.isCompletable = bl7;
    }

    public Object adapt(Call<R> callEnqueueObservable) {
        Object object = this.isAsync ? new CallEnqueueObservable(callEnqueueObservable) : new CallExecuteObservable(callEnqueueObservable);
        if (this.isResult) {
            callEnqueueObservable = new ResultObservable((Observable)object);
        } else {
            callEnqueueObservable = object;
            if (this.isBody) {
                callEnqueueObservable = new BodyObservable((Observable)object);
            }
        }
        Scheduler scheduler = this.scheduler;
        object = callEnqueueObservable;
        if (scheduler != null) {
            object = callEnqueueObservable.subscribeOn(scheduler);
        }
        if (this.isFlowable) {
            return object.toFlowable(BackpressureStrategy.LATEST);
        }
        if (this.isSingle) {
            return object.singleOrError();
        }
        if (this.isMaybe) {
            return object.singleElement();
        }
        if (!this.isCompletable) return RxJavaPlugins.onAssembly((Observable)object);
        return object.ignoreElements();
    }

    public Type responseType() {
        return this.responseType;
    }
}
