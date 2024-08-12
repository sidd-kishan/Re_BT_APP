/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableOperator
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T>
extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> operator;

    public FlowableLift(Flowable<T> flowable, FlowableOperator<? extends R, ? super T> flowableOperator) {
        super(flowable);
        this.operator = flowableOperator;
    }

    public void subscribeActual(Subscriber<? super R> object) {
        try {
            object = this.operator.apply(object);
            if (object != null) {
                this.source.subscribe((Subscriber)object);
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Operator ");
            ((StringBuilder)object).append(this.operator);
            ((StringBuilder)object).append(" returned a null Subscriber");
            NullPointerException nullPointerException = new NullPointerException(((StringBuilder)object).toString());
            throw nullPointerException;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }
}
