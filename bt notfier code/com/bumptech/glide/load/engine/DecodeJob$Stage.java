/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine;

private static final class DecodeJob.Stage
extends Enum<DecodeJob.Stage> {
    private static final DecodeJob.Stage[] $VALUES;
    public static final /* enum */ DecodeJob.Stage DATA_CACHE;
    public static final /* enum */ DecodeJob.Stage ENCODE;
    public static final /* enum */ DecodeJob.Stage FINISHED;
    public static final /* enum */ DecodeJob.Stage INITIALIZE;
    public static final /* enum */ DecodeJob.Stage RESOURCE_CACHE;
    public static final /* enum */ DecodeJob.Stage SOURCE;

    static {
        DecodeJob.Stage stage;
        INITIALIZE = new DecodeJob.Stage();
        RESOURCE_CACHE = new DecodeJob.Stage();
        DATA_CACHE = new DecodeJob.Stage();
        SOURCE = new DecodeJob.Stage();
        ENCODE = new DecodeJob.Stage();
        FINISHED = stage = new DecodeJob.Stage();
        $VALUES = new DecodeJob.Stage[]{INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, stage};
    }

    public static DecodeJob.Stage valueOf(String string) {
        return Enum.valueOf(DecodeJob.Stage.class, string);
    }

    public static DecodeJob.Stage[] values() {
        return (DecodeJob.Stage[])$VALUES.clone();
    }
}
