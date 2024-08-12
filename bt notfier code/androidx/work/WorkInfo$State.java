/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public static final class WorkInfo.State
extends Enum<WorkInfo.State> {
    private static final WorkInfo.State[] $VALUES;
    public static final /* enum */ WorkInfo.State BLOCKED;
    public static final /* enum */ WorkInfo.State CANCELLED;
    public static final /* enum */ WorkInfo.State ENQUEUED;
    public static final /* enum */ WorkInfo.State FAILED;
    public static final /* enum */ WorkInfo.State RUNNING;
    public static final /* enum */ WorkInfo.State SUCCEEDED;

    static {
        WorkInfo.State state;
        ENQUEUED = new WorkInfo.State();
        RUNNING = new WorkInfo.State();
        SUCCEEDED = new WorkInfo.State();
        FAILED = new WorkInfo.State();
        BLOCKED = new WorkInfo.State();
        CANCELLED = state = new WorkInfo.State();
        $VALUES = new WorkInfo.State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, state};
    }

    public static WorkInfo.State valueOf(String string) {
        return Enum.valueOf(WorkInfo.State.class, string);
    }

    public static WorkInfo.State[] values() {
        return (WorkInfo.State[])$VALUES.clone();
    }

    public boolean isFinished() {
        boolean bl = this == SUCCEEDED || this == FAILED || this == CANCELLED;
        return bl;
    }
}
