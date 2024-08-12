/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.util;

public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(Exception exception) {
        SneakyThrow.sneakyThrow(exception);
    }

    private static <E extends Throwable> void sneakyThrow(Throwable throwable) throws E {
        throw throwable;
    }
}
