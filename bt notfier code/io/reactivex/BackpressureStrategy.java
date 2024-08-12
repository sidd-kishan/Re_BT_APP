/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex;

public final class BackpressureStrategy
extends Enum<BackpressureStrategy> {
    private static final BackpressureStrategy[] $VALUES;
    public static final /* enum */ BackpressureStrategy BUFFER;
    public static final /* enum */ BackpressureStrategy DROP;
    public static final /* enum */ BackpressureStrategy ERROR;
    public static final /* enum */ BackpressureStrategy LATEST;
    public static final /* enum */ BackpressureStrategy MISSING;

    static {
        BackpressureStrategy backpressureStrategy;
        MISSING = new BackpressureStrategy();
        ERROR = new BackpressureStrategy();
        BUFFER = new BackpressureStrategy();
        DROP = new BackpressureStrategy();
        LATEST = backpressureStrategy = new BackpressureStrategy();
        $VALUES = new BackpressureStrategy[]{MISSING, ERROR, BUFFER, DROP, backpressureStrategy};
    }

    public static BackpressureStrategy valueOf(String string) {
        return Enum.valueOf(BackpressureStrategy.class, string);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[])$VALUES.clone();
    }
}
