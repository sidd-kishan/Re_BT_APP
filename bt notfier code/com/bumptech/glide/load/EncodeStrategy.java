/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

public final class EncodeStrategy
extends Enum<EncodeStrategy> {
    private static final EncodeStrategy[] $VALUES;
    public static final /* enum */ EncodeStrategy NONE;
    public static final /* enum */ EncodeStrategy SOURCE;
    public static final /* enum */ EncodeStrategy TRANSFORMED;

    static {
        EncodeStrategy encodeStrategy;
        SOURCE = new EncodeStrategy();
        TRANSFORMED = new EncodeStrategy();
        NONE = encodeStrategy = new EncodeStrategy();
        $VALUES = new EncodeStrategy[]{SOURCE, TRANSFORMED, encodeStrategy};
    }

    public static EncodeStrategy valueOf(String string) {
        return Enum.valueOf(EncodeStrategy.class, string);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[])$VALUES.clone();
    }
}
