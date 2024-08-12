/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex;

public final class BackpressureOverflowStrategy
extends Enum<BackpressureOverflowStrategy> {
    private static final BackpressureOverflowStrategy[] $VALUES;
    public static final /* enum */ BackpressureOverflowStrategy DROP_LATEST;
    public static final /* enum */ BackpressureOverflowStrategy DROP_OLDEST;
    public static final /* enum */ BackpressureOverflowStrategy ERROR;

    static {
        BackpressureOverflowStrategy backpressureOverflowStrategy;
        ERROR = new BackpressureOverflowStrategy();
        DROP_OLDEST = new BackpressureOverflowStrategy();
        DROP_LATEST = backpressureOverflowStrategy = new BackpressureOverflowStrategy();
        $VALUES = new BackpressureOverflowStrategy[]{ERROR, DROP_OLDEST, backpressureOverflowStrategy};
    }

    public static BackpressureOverflowStrategy valueOf(String string) {
        return Enum.valueOf(BackpressureOverflowStrategy.class, string);
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[])$VALUES.clone();
    }
}
