/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeToFlowable
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import org.reactivestreams.Publisher;

public final class MaybeToPublisher
extends Enum<MaybeToPublisher>
implements Function<MaybeSource<Object>, Publisher<Object>> {
    private static final MaybeToPublisher[] $VALUES;
    public static final /* enum */ MaybeToPublisher INSTANCE;

    static {
        MaybeToPublisher maybeToPublisher;
        INSTANCE = maybeToPublisher = new MaybeToPublisher();
        $VALUES = new MaybeToPublisher[]{maybeToPublisher};
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String string) {
        return Enum.valueOf(MaybeToPublisher.class, string);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[])$VALUES.clone();
    }

    public Publisher<Object> apply(MaybeSource<Object> maybeSource) throws Exception {
        return new MaybeToFlowable(maybeSource);
    }
}
