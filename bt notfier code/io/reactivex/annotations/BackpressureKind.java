/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.annotations;

public final class BackpressureKind
extends Enum<BackpressureKind> {
    private static final BackpressureKind[] $VALUES;
    public static final /* enum */ BackpressureKind ERROR;
    public static final /* enum */ BackpressureKind FULL;
    public static final /* enum */ BackpressureKind NONE;
    public static final /* enum */ BackpressureKind PASS_THROUGH;
    public static final /* enum */ BackpressureKind SPECIAL;
    public static final /* enum */ BackpressureKind UNBOUNDED_IN;

    static {
        BackpressureKind backpressureKind;
        PASS_THROUGH = new BackpressureKind();
        FULL = new BackpressureKind();
        SPECIAL = new BackpressureKind();
        UNBOUNDED_IN = new BackpressureKind();
        ERROR = new BackpressureKind();
        NONE = backpressureKind = new BackpressureKind();
        $VALUES = new BackpressureKind[]{PASS_THROUGH, FULL, SPECIAL, UNBOUNDED_IN, ERROR, backpressureKind};
    }

    public static BackpressureKind valueOf(String string) {
        return Enum.valueOf(BackpressureKind.class, string);
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[])$VALUES.clone();
    }
}
