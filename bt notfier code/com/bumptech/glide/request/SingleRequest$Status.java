/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.request;

private static final class SingleRequest.Status
extends Enum<SingleRequest.Status> {
    private static final SingleRequest.Status[] $VALUES;
    public static final /* enum */ SingleRequest.Status CANCELLED;
    public static final /* enum */ SingleRequest.Status CLEARED;
    public static final /* enum */ SingleRequest.Status COMPLETE;
    public static final /* enum */ SingleRequest.Status FAILED;
    public static final /* enum */ SingleRequest.Status PAUSED;
    public static final /* enum */ SingleRequest.Status PENDING;
    public static final /* enum */ SingleRequest.Status RUNNING;
    public static final /* enum */ SingleRequest.Status WAITING_FOR_SIZE;

    static {
        SingleRequest.Status status;
        PENDING = new SingleRequest.Status();
        RUNNING = new SingleRequest.Status();
        WAITING_FOR_SIZE = new SingleRequest.Status();
        COMPLETE = new SingleRequest.Status();
        FAILED = new SingleRequest.Status();
        CANCELLED = new SingleRequest.Status();
        CLEARED = new SingleRequest.Status();
        PAUSED = status = new SingleRequest.Status();
        $VALUES = new SingleRequest.Status[]{PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CANCELLED, CLEARED, status};
    }

    public static SingleRequest.Status valueOf(String string) {
        return Enum.valueOf(SingleRequest.Status.class, string);
    }

    public static SingleRequest.Status[] values() {
        return (SingleRequest.Status[])$VALUES.clone();
    }
}
