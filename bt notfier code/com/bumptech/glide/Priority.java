/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide;

public final class Priority
extends Enum<Priority> {
    private static final Priority[] $VALUES;
    public static final /* enum */ Priority HIGH;
    public static final /* enum */ Priority IMMEDIATE;
    public static final /* enum */ Priority LOW;
    public static final /* enum */ Priority NORMAL;

    static {
        Priority priority;
        IMMEDIATE = new Priority();
        HIGH = new Priority();
        NORMAL = new Priority();
        LOW = priority = new Priority();
        $VALUES = new Priority[]{IMMEDIATE, HIGH, NORMAL, priority};
    }

    public static Priority valueOf(String string) {
        return Enum.valueOf(Priority.class, string);
    }

    public static Priority[] values() {
        return (Priority[])$VALUES.clone();
    }
}
