/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine;

private static final class DecodeJob.RunReason
extends Enum<DecodeJob.RunReason> {
    private static final DecodeJob.RunReason[] $VALUES;
    public static final /* enum */ DecodeJob.RunReason DECODE_DATA;
    public static final /* enum */ DecodeJob.RunReason INITIALIZE;
    public static final /* enum */ DecodeJob.RunReason SWITCH_TO_SOURCE_SERVICE;

    static {
        DecodeJob.RunReason runReason;
        INITIALIZE = new DecodeJob.RunReason();
        SWITCH_TO_SOURCE_SERVICE = new DecodeJob.RunReason();
        DECODE_DATA = runReason = new DecodeJob.RunReason();
        $VALUES = new DecodeJob.RunReason[]{INITIALIZE, SWITCH_TO_SOURCE_SERVICE, runReason};
    }

    public static DecodeJob.RunReason valueOf(String string) {
        return Enum.valueOf(DecodeJob.RunReason.class, string);
    }

    public static DecodeJob.RunReason[] values() {
        return (DecodeJob.RunReason[])$VALUES.clone();
    }
}
