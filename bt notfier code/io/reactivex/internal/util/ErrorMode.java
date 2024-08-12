/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

public final class ErrorMode
extends Enum<ErrorMode> {
    private static final ErrorMode[] $VALUES;
    public static final /* enum */ ErrorMode BOUNDARY;
    public static final /* enum */ ErrorMode END;
    public static final /* enum */ ErrorMode IMMEDIATE;

    static {
        ErrorMode errorMode;
        IMMEDIATE = new ErrorMode();
        BOUNDARY = new ErrorMode();
        END = errorMode = new ErrorMode();
        $VALUES = new ErrorMode[]{IMMEDIATE, BOUNDARY, errorMode};
    }

    public static ErrorMode valueOf(String string) {
        return Enum.valueOf(ErrorMode.class, string);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[])$VALUES.clone();
    }
}
