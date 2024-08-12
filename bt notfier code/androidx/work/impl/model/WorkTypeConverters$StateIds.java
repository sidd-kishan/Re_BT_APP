/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.model;

public static interface WorkTypeConverters.StateIds {
    public static final int BLOCKED = 4;
    public static final int CANCELLED = 5;
    public static final String COMPLETED_STATES = "(2, 3, 5)";
    public static final int ENQUEUED = 0;
    public static final int FAILED = 3;
    public static final int RUNNING = 1;
    public static final int SUCCEEDED = 2;
}
