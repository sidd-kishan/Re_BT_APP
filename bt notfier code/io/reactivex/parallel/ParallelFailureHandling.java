/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 */
package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

public final class ParallelFailureHandling
extends Enum<ParallelFailureHandling>
implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    private static final ParallelFailureHandling[] $VALUES;
    public static final /* enum */ ParallelFailureHandling ERROR;
    public static final /* enum */ ParallelFailureHandling RETRY;
    public static final /* enum */ ParallelFailureHandling SKIP;
    public static final /* enum */ ParallelFailureHandling STOP;

    static {
        ParallelFailureHandling parallelFailureHandling;
        STOP = new ParallelFailureHandling();
        ERROR = new ParallelFailureHandling();
        SKIP = new ParallelFailureHandling();
        RETRY = parallelFailureHandling = new ParallelFailureHandling();
        $VALUES = new ParallelFailureHandling[]{STOP, ERROR, SKIP, parallelFailureHandling};
    }

    public static ParallelFailureHandling valueOf(String string) {
        return Enum.valueOf(ParallelFailureHandling.class, string);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[])$VALUES.clone();
    }

    public ParallelFailureHandling apply(Long l, Throwable throwable) {
        return this;
    }
}
