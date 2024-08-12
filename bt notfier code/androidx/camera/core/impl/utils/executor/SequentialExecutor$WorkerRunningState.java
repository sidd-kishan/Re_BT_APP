/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.executor;

static final class SequentialExecutor.WorkerRunningState
extends Enum<SequentialExecutor.WorkerRunningState> {
    private static final SequentialExecutor.WorkerRunningState[] $VALUES;
    public static final /* enum */ SequentialExecutor.WorkerRunningState IDLE;
    public static final /* enum */ SequentialExecutor.WorkerRunningState QUEUED;
    public static final /* enum */ SequentialExecutor.WorkerRunningState QUEUING;
    public static final /* enum */ SequentialExecutor.WorkerRunningState RUNNING;

    static {
        SequentialExecutor.WorkerRunningState workerRunningState;
        IDLE = new SequentialExecutor.WorkerRunningState();
        QUEUING = new SequentialExecutor.WorkerRunningState();
        QUEUED = new SequentialExecutor.WorkerRunningState();
        RUNNING = workerRunningState = new SequentialExecutor.WorkerRunningState();
        $VALUES = new SequentialExecutor.WorkerRunningState[]{IDLE, QUEUING, QUEUED, workerRunningState};
    }

    public static SequentialExecutor.WorkerRunningState valueOf(String string) {
        return Enum.valueOf(SequentialExecutor.WorkerRunningState.class, string);
    }

    public static SequentialExecutor.WorkerRunningState[] values() {
        return (SequentialExecutor.WorkerRunningState[])$VALUES.clone();
    }
}
