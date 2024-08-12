/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.processors.SerializedProcessor
 *  org.reactivestreams.Processor
 */
package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.processors.SerializedProcessor;
import org.reactivestreams.Processor;

public abstract class FlowableProcessor<T>
extends Flowable<T>
implements Processor<T, T>,
FlowableSubscriber<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    @CheckReturnValue
    public final FlowableProcessor<T> toSerialized() {
        if (!(this instanceof SerializedProcessor)) return new SerializedProcessor(this);
        return this;
    }
}
