/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Response
 *  retrofit2.Retrofit
 *  retrofit2.adapter.rxjava2.Result
 *  retrofit2.adapter.rxjava2.RxJava2CallAdapter
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.adapter.rxjava2.RxJava2CallAdapter;

public final class RxJava2CallAdapterFactory
extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final Scheduler scheduler;

    private RxJava2CallAdapterFactory(@Nullable Scheduler scheduler, boolean bl) {
        this.scheduler = scheduler;
        this.isAsync = bl;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler) {
        if (scheduler == null) throw new NullPointerException("scheduler == null");
        return new RxJava2CallAdapterFactory(scheduler, false);
    }

    /*
     * Enabled force condition propagation
     */
    @Nullable
    public CallAdapter<?, ?> get(Type object, Annotation[] object2, Retrofit retrofit) {
        boolean bl;
        boolean bl2;
        object2 = RxJava2CallAdapterFactory.getRawType((Type)object);
        if (object2 == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean bl3 = object2 == Flowable.class;
        boolean bl4 = object2 == Single.class;
        boolean bl5 = object2 == Maybe.class;
        if (!(object2 == Observable.class || bl3 || bl4 || bl5)) {
            return null;
        }
        if (!(object instanceof ParameterizedType)) {
            object = !bl3 ? (!bl4 ? (bl5 ? "Maybe" : "Observable") : "Single") : "Flowable";
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" return type must be parameterized as ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("<Foo> or ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("<? extends Foo>");
            throw new IllegalStateException(((StringBuilder)object2).toString());
        }
        object2 = RxJava2CallAdapterFactory.getRawType((Type)(object = RxJava2CallAdapterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)object))));
        if (object2 == Response.class) {
            if (!(object instanceof ParameterizedType)) throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            object = RxJava2CallAdapterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)object));
            bl2 = false;
        } else {
            if (object2 != Result.class) {
                bl2 = false;
                bl = true;
                return new RxJava2CallAdapter((Type)object, this.scheduler, this.isAsync, bl2, bl, bl3, bl4, bl5, false);
            }
            if (!(object instanceof ParameterizedType)) throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            object = RxJava2CallAdapterFactory.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)object));
            bl2 = true;
        }
        bl = false;
        return new RxJava2CallAdapter((Type)object, this.scheduler, this.isAsync, bl2, bl, bl3, bl4, bl5, false);
    }
}
